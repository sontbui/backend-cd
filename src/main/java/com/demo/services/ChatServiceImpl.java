package com.demo.services;

import java.util.Date;
import java.util.List;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.DTO.CDDTO;
import com.demo.DTO.ChatDTO;
import com.demo.DTO.GenreDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.Cd;
import com.demo.entities.Chat;
import com.demo.entities.Genre;
import com.demo.entities.User;
import com.demo.repositories.CDRepository;
import com.demo.repositories.ChatRepository;
import com.demo.repositories.GenreRepository;
import com.demo.repositories.UserRepository;

@Service
public class ChatServiceImpl implements ChatService{
	@Autowired
	private ChatRepository chatRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;

	
	@Override
	public List<Chat> findListChat(Integer senderId, Integer receiverId) {
		return mapper.map(chatRepository.findListChat(senderId, receiverId), new TypeToken<List<ChatDTO>>() {}.getType());
	}


	@Override
	public boolean save(ChatDTO chatDTO) {
		try {
			chatDTO.setTime(new Date());
			User sender = userRepository.findById(chatDTO.getSenderID()).get();
			User receiver = userRepository.findById(chatDTO.getReceiverID()).get();
			Chat chat = mapper.map(chatDTO, Chat.class);
			chat.setSender(sender);
			chat.setReceiver(receiver);
			chatRepository.save(chat);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public List<Chat> findLastMessagesToAdmin(Integer adminId) {
		return mapper.map(chatRepository.findLastMessagesToAdmin(adminId), new TypeToken<List<ChatDTO>>() {}.getType());
	}
	
	
	
}
