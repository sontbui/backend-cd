//package com.demo.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.demo.DTO.ChatDTO;
//
//@Controller
//public class ChatWebSocketController {
//
//    private final SimpMessagingTemplate messagingTemplate;
//
//    @Autowired
//    public ChatWebSocketController(SimpMessagingTemplate messagingTemplate) {
//        this.messagingTemplate = messagingTemplate;
//    }
//
//    public void broadcastMessage(ChatDTO chatMessage) {
//        messagingTemplate.convertAndSend("/topic/messages", chatMessage);
//    }
//}
