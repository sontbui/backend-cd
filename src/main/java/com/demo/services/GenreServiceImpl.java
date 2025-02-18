package com.demo.services;

import java.util.List;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.DTO.GenreDTO;
import com.demo.DTO.UserDTO;

import com.demo.entities.Genre;
import com.demo.entities.User;
import com.demo.repositories.GenreRepository;
import com.demo.repositories.UserRepository;

@Service
public class GenreServiceImpl implements GenreService{
	@Autowired
	private GenreRepository genreRepository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Override
	public Iterable<Genre> findAll() {
		return mapper.map(genreRepository.findAll(), new TypeToken<List<GenreDTO>>() {}.getType());
	}
	@Override
	public boolean save(GenreDTO genreDTO) {
		try {
			Genre genre = mapper.map(genreDTO, Genre.class);
			genreRepository.save(genre);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
