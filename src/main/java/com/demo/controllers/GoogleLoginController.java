package com.demo.controllers;

import com.demo.DTO.UserDTO;
import com.demo.services.UserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
@RestController
@RequestMapping("/api/google-login")
public class GoogleLoginController {

    private static final String CLIENT_ID = "367668387063-6hrqhstfanulgnoe9uf3gjqc283vomcc.apps.googleusercontent.com"; // Thay bằng Client ID của bạn
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> googleLogin(@RequestBody Map<String, String> requestBody) throws Exception {
        String idTokenString = requestBody.get("idToken");

        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY)
                .setAudience(Collections.singletonList(CLIENT_ID))
                .build();

        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken != null) {
            GoogleIdToken.Payload payload = idToken.getPayload();

            // Lấy thông tin từ token
            String googleId = payload.getSubject();
            String email = payload.getEmail();
            String name = (String) payload.get("name");
            String avatar = (String) payload.get("picture");
            System.out.println(googleId);
            // Lưu hoặc cập nhật user
            Optional<UserDTO> optionalUser = userService.findByGoogleId(googleId);
            UserDTO user = optionalUser.orElseGet(() -> {
                System.out.println("Creating new user");
                UserDTO newUser = new UserDTO();
                newUser.setGoogleId(googleId);
                newUser.setUsername(email);
                newUser.setEmail(email);
                newUser.setFullName(name);
                newUser.setAvatar(avatar);
                newUser.setRole(1);
                newUser.setPassword("$2a$10$EGz5UXiizIxOG0fvJz2mM.0u4rcfA6KVBZx897NkzfNrRB/p/fRLa"); // Mật khẩu mặc định hoặc null nếu không cần
                newUser.setIsGoogleAccount(true);
                newUser.setStatus(1); // Trạng thái mặc định
                userService.save(newUser); // Lưu người dùng mới vào DB
                return newUser;
            });

            // Trả về DTO rút gọn hoặc thông báo
            return ResponseEntity.ok(user);
        } else {
        	System.out.println("th2");
            return ResponseEntity.badRequest().body("Invalid ID Token");
        }
    }
}