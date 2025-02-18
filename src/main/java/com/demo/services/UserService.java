package com.demo.services;

import java.util.List;
import java.util.Optional;

import com.demo.DTO.GenreDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.User;

public interface UserService {
	public Iterable<User> findAll();
	public boolean checkLogin(String username, String password);
	public UserDTO findByUsername(String username);
	public UserDTO findByEmail(String email);
	public UserDTO findById(int id);
	public boolean save(UserDTO userDTO);
	public Optional<UserDTO> findByGoogleId(String googleId);
}
