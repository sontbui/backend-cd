package com.demo.services;

import java.util.List;

import com.demo.DTO.ArtistDTO;

public interface ArtistService {
	public ArtistDTO findByID(int id);
	
	public List<ArtistDTO> findAll();
	
	public boolean save(ArtistDTO artistDTO);
}
