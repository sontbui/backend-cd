package com.demo.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.DTO.CDDTO;
import com.demo.DTO.OrderDetailsDTO;
import com.demo.entities.Cd;
import com.demo.entities.Orderdetails;


@Configuration
public class ModelMapperConfiguration {
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.addMappings(new PropertyMap<Cd, CDDTO>() {
			@Override
			protected void configure() {
				map().setArtistID(source.getArtist().getId());
				map().setArtistName(source.getArtist().getName());
			}
			
		});
		mapper.addMappings(new PropertyMap<Orderdetails, OrderDetailsDTO>() {
			@Override
			protected void configure() {
				map().setCdTitle(source.getCd().getTitle());
			}
			
		});
		return mapper;
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
