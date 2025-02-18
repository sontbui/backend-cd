package com.demo.services;

import java.util.List;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.DTO.GenreDTO;
import com.demo.DTO.PhotoDTO;
import com.demo.DTO.UserDTO;

import com.demo.entities.Genre;
import com.demo.entities.Photo;
import com.demo.entities.User;
import com.demo.repositories.GenreRepository;
import com.demo.repositories.PhotoRepository;
import com.demo.repositories.UserRepository;

@Service
public class PhotoServiceImpl implements PhotoService{
	@Autowired
	private PhotoRepository photoRepository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Override
	public List<Photo> findByCDId(int id) {
		return mapper.map(photoRepository.findByCDId(id), new TypeToken<List<PhotoDTO>>() {}.getType());
	}
	
	
	
}
