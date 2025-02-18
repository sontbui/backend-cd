package com.demo.services;

import java.util.List;

import com.demo.DTO.DeliveryInfoDTO;
import com.demo.DTO.CDDTO;
import com.demo.DTO.GenreDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.Cd;
import com.demo.entities.DeliveryInfo;
import com.demo.entities.Genre;
import com.demo.entities.User;

public interface DeliveryInfoService {

	public List<DeliveryInfo> findByUserId(int id);
	public boolean save(DeliveryInfoDTO deliveryInfoDTO);
}
