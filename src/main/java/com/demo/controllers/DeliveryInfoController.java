package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.util.MimeTypeUtils;

import com.demo.DTO.DeliveryInfoDTO;
import com.demo.DTO.GenreDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.DeliveryInfo;
import com.demo.entities.Genre;
import com.demo.entities.Photo;
import com.demo.entities.User;
import com.demo.repositories.GenreRepository;
import com.demo.services.DeliveryInfoService;
import com.demo.services.GenreService;
import com.demo.services.PhotoService;
import com.demo.services.UserService;
@Controller

@RequestMapping("api/deliveryInfo")




public class DeliveryInfoController {
	@Autowired
	private DeliveryInfoService deliveryInfoService;
//	@GetMapping(value = "findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Iterable<Genre>> findAll(){
//		try {
//			return new ResponseEntity<Iterable<Genre>>(genreService.findAll(), HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<Iterable<Genre>>(HttpStatus.BAD_REQUEST);
//		}
//	}
	@PutMapping(value = "update", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody DeliveryInfoDTO deliveryInfoDTO){
		try {
			return new ResponseEntity<Object>(new Object() {
				public boolean status = deliveryInfoService.save(deliveryInfoDTO);
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping(value = "add", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> add(@RequestBody DeliveryInfoDTO deliveryInfoDTO){
		try {
			return new ResponseEntity<Object>(new Object() {
				public boolean status = deliveryInfoService.save(deliveryInfoDTO);
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping(value = "findByUserId/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DeliveryInfo>> findByUsername(@PathVariable("id") int id){
		try {
			return new ResponseEntity<List<DeliveryInfo>>(deliveryInfoService.findByUserId(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<DeliveryInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
}
