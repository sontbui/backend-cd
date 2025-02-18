package com.demo.services;

import java.util.List;
import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.DTO.DeliveryInfoDTO;
import com.demo.DTO.CDDTO;
import com.demo.DTO.GenreDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.Cd;
import com.demo.entities.DeliveryInfo;
import com.demo.entities.Genre;
import com.demo.entities.User;
import com.demo.repositories.CDRepository;
import com.demo.repositories.DeliveryInfoRepository;
import com.demo.repositories.GenreRepository;
import com.demo.repositories.UserRepository;

@Service
public class DeliveryInfoServiceIml implements DeliveryInfoService{
	@Autowired
	private DeliveryInfoRepository deliveryInfoRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;


	@Override
	public List<DeliveryInfo> findByUserId(int id) {
		return mapper.map(deliveryInfoRepository.findByUserId(id), new TypeToken<List<DeliveryInfoDTO>>() {}.getType());
	}


	@Override
	public boolean save(DeliveryInfoDTO deliveryInfoDTO) {
		try {
			User user = userRepository.findById(deliveryInfoDTO.getUserID()).get();
			DeliveryInfo deliveryInfo = mapper.map(deliveryInfoDTO, DeliveryInfo.class);
			deliveryInfo.setUser(user);
			deliveryInfoRepository.save(deliveryInfo);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
