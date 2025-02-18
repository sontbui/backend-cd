package com.demo.services;

import java.util.List;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.DTO.CDDTO;
import com.demo.DTO.GenreDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.Cd;
import com.demo.entities.Genre;
import com.demo.entities.User;
import com.demo.repositories.CDRepository;
import com.demo.repositories.GenreRepository;
import com.demo.repositories.UserRepository;

@Service
public class CDServiceImpl implements CDService{
	@Autowired
	private CDRepository cdRepository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Override
	public Iterable<Cd> findAll() {
		return mapper.map(cdRepository.findAll(), new TypeToken<List<CDDTO>>() {}.getType());
	}
	@Override
	public boolean save(CDDTO cddto) {
		try {
			Cd cd = mapper.map(cddto, Cd.class);
			cdRepository.save(cd);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public CDDTO findById(int id) {
		return mapper.map(cdRepository.findById(id).get(), CDDTO.class);
	}
	@Override
	public List<Cd> findByGenreId(int id) {
		return mapper.map(cdRepository.findByGenreId(id), new TypeToken<List<CDDTO>>() {}.getType());
	}
	
}
