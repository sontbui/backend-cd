package com.demo.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.demo.DTO.CDDTO;
import com.demo.DTO.ChatDTO;
import com.demo.DTO.GenreDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.Cd;
import com.demo.entities.Chat;
import com.demo.entities.Genre;
import com.demo.entities.User;

public interface ChatService {
	List<Chat> findListChat(Integer senderId, Integer receiverId);
	public boolean save(ChatDTO chatDTO);
	List<Chat> findLastMessagesToAdmin(Integer adminId);
}
