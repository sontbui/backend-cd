package com.demo.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.MimeTypeUtils;

import com.demo.DTO.GenreDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.User;
import com.demo.helpers.FileHelper;
import com.demo.services.UserService;
@Controller

@RequestMapping("api/user")




public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping(value = "findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<User>> findAll(){
		try {
			return new ResponseEntity<Iterable<User>>(userService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Iterable<User>>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping(value = "login", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> checkLogin(@RequestBody UserDTO userDTO){
		try {
			return new ResponseEntity<Object>(new Object() {
				public String msg = userService.checkLogin(userDTO.getUsername(), userDTO.getPassword()) ? "Ban da dang nhap thanh cong" : "Ban dang nhap that bai";
				public boolean status = userService.checkLogin(userDTO.getUsername(), userDTO.getPassword());
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping(value = "findByUsername/{username}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> findByUsername(@PathVariable("username") String username){
		try {
			return new ResponseEntity<UserDTO>(userService.findByUsername(username), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping(value = "findByEmail/{email}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> findByEmail(@PathVariable("email") String email){
		try {
			return new ResponseEntity<UserDTO>(userService.findByEmail(email), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping(value = "findById/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> findById(@PathVariable("id") int id){
		try {
			return new ResponseEntity<UserDTO>(userService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping(value = "update", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody UserDTO userDTO){
		try {
			return new ResponseEntity<Object>(new Object() {
				public boolean status = userService.save(userDTO);
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping(value = "create", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody UserDTO userDTO){
		try {
			return new ResponseEntity<Object>(new Object() {
				public boolean status = userService.save(userDTO);
				public UserDTO user = userService.findByUsername(userDTO.getUsername());
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping(value = "upload", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			// Kiểm tra xem tệp có rỗng không
			if (file.isEmpty()) {
				return new ResponseEntity<>("File is empty", HttpStatus.BAD_REQUEST);
			}

		
			// Lấy thông tin của tệp
			String originalFilename = file.getOriginalFilename();
			String contentType = file.getContentType();
			long size = file.getSize();

			// Thư mục lưu trữ tệp
			File uploadFolder = new File(new ClassPathResource("static/assets/images").getFile().getAbsolutePath());
			if (!uploadFolder.exists()) {
				uploadFolder.mkdirs();
			}

			// Tạo tên tệp duy nhất
			String filename = FileHelper.generateFileName(originalFilename); // hoặc sử dụng phương thức generateFileName

			// Tạo đường dẫn lưu trữ tệp
			Path path = Paths.get(uploadFolder.getAbsolutePath() + File.separator + filename);

			// Lưu tệp vào thư mục
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			// Tạo URL cho tệp đã tải lên
			String fileUrl = filename;
			System.out.println(path);
			System.out.println(fileUrl);
			// Trả về URL của tệp đã tải lên
			return ResponseEntity.ok().body(new Object() {
				public String url = fileUrl;
			});
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
		}
}
}
