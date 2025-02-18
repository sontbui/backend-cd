package com.demo.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.demo.DTO.CDDTO;
import com.demo.DTO.GenreDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.Cd;
import com.demo.entities.Genre;
import com.demo.entities.User;

public interface CDService {
	public Iterable<Cd> findAll();
	public boolean save(CDDTO cddto);
	public CDDTO findById(int id);
	public List<Cd> findByGenreId(int id);
}
