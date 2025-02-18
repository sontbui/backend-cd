package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.DTO.ChatDTO;
import com.demo.entities.Chat;
import com.demo.services.ChatService;

@Controller
@RequestMapping("api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping(value = "findListChat/{senderId}/{receiverId}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Chat>> findBySenderAndReceiver(
            @PathVariable("senderId") Integer senderId,
            @PathVariable("receiverId") Integer receiverId) {
        try {
            List<Chat> messages = chatService.findListChat(senderId, receiverId);
            return new ResponseEntity<List<Chat>>(messages, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Chat>>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "findListChatAdmin/{adminId}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Chat>> findListChatAdmin(
            @PathVariable("adminId") Integer adminId
           ) {
        try {
            List<Chat> messages = chatService.findLastMessagesToAdmin(adminId);
            return new ResponseEntity<List<Chat>>(messages, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Chat>>(HttpStatus.BAD_REQUEST);
        }
    }


}
