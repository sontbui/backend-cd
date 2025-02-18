package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.DTO.UserDTO;
import com.demo.entities.Genre;
import com.demo.entities.User;
import com.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Override
	public Iterable<User> findAll() {
		return mapper.map(userRepository.findAll(), new TypeToken<List<UserDTO>>() {}.getType());
	}

	@Override
	public boolean checkLogin(String username, String password) {
		User user = userRepository.findByUserName(username);
		if(user != null && user.getStatus() == 1) {
			return encoder.matches(password, user.getPassword());
		}
		return false;
	}

	@Override
	public UserDTO findByUsername(String username) {
		return mapper.map(userRepository.findByUserName(username), UserDTO.class);
	}

	@Override
	public boolean save(UserDTO userDTO) {
		try {
			User user = mapper.map(userDTO, User.class);
			userRepository.save(user);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public UserDTO findById(int id) {
		return mapper.map(userRepository.findById(id).get(), UserDTO.class);
	}

	@Override
	public UserDTO findByEmail(String email) {
		return mapper.map(userRepository.findByEmail(email), UserDTO.class);
	}

	@Override
	public Optional<UserDTO> findByGoogleId(String googleId) {
		 return userRepository.findByGoogleId(googleId)
		            .map(user -> {
		                // Ánh xạ User sang UserDTO
		                UserDTO userDTO = new UserDTO();
		                BeanUtils.copyProperties(user, userDTO);
		                return userDTO; // Trả về UserDTO
		            });
	}
	
	
}
