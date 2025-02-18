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

import com.demo.DTO.GenreDTO;
import com.demo.DTO.OrderDTO;
import com.demo.DTO.OrderDetailsDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.Genre;
import com.demo.entities.User;
import com.demo.repositories.GenreRepository;
import com.demo.services.GenreService;
import com.demo.services.OrderDetailsService;
import com.demo.services.OrderService;
import com.demo.services.UserService;
@Controller

@RequestMapping("api/orderDetails")




public class OrderDetailsController {
	@Autowired
	private OrderDetailsService orderDetailsService;
//	@GetMapping(value = "findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Iterable<Genre>> findAll(){
//		try {
//			return new ResponseEntity<Iterable<Genre>>(genreService.findAll(), HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<Iterable<Genre>>(HttpStatus.BAD_REQUEST);
//		}
//	}
	@PostMapping(value = "create", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody OrderDetailsDTO orderDetailsDTO){
		try {
			return new ResponseEntity<Object>(new Object() {
				public boolean status = orderDetailsService.save(orderDetailsDTO);
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "findByOrderID/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDetailsDTO>> findByOrderID(@PathVariable("id") int id){
		try {
			return new ResponseEntity<List<OrderDetailsDTO>>(orderDetailsService.findByOrderID(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<OrderDetailsDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
}
