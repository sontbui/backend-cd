package com.demo.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DTO.ArtistDTO;
import com.demo.DTO.CDDTO;
import com.demo.entities.Artist;
import com.demo.entities.Cd;
import com.demo.repositories.ArtistRepository;
@Service
public class ArtistServiceImpl implements ArtistService{
	@Autowired
	private ArtistRepository artistRepository;
	@Autowired
	private ModelMapper mapper;
	@Override
	public ArtistDTO findByID(int id) {
		return mapper.map(artistRepository.findById(id).get(), ArtistDTO.class);
	}
	@Override
	public List<ArtistDTO> findAll() {
		return mapper.map(artistRepository.findAll(), new TypeToken<List<ArtistDTO>>() {}.getType());
	}
	@Override
	public boolean save(ArtistDTO artistDTO) {
		try {
			Artist artist = mapper.map(artistDTO, Artist.class);
			artistRepository.save(artist);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
