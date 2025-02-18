package com.demo.services;

import java.util.List;

import com.demo.DTO.GenreDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.Genre;
import com.demo.entities.User;

public interface GenreService {
	public Iterable<Genre> findAll();
	public boolean save(GenreDTO genreDTO);
}
