package com.demo.services;

import java.util.List;

import com.demo.DTO.PhotoDTO;
import com.demo.entities.Photo;

public interface PhotoService {
	public List<Photo> findByCDId(int id);
}
