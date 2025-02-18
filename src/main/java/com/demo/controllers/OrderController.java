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
import com.demo.DTO.UserDTO;
import com.demo.entities.Genre;
import com.demo.entities.User;
import com.demo.repositories.GenreRepository;
import com.demo.services.GenreService;
import com.demo.services.OrderService;
import com.demo.services.UserService;
@Controller

@RequestMapping("api/order")




public class OrderController {
	@Autowired
	private OrderService orderService;
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
	public ResponseEntity<Object> create(@RequestBody OrderDTO orderDTO){
		try {
			return new ResponseEntity<Object>(new Object() {
				public int orderID
				= orderService.save(orderDTO);
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping(value = "update", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody OrderDTO orderDTO){
		try {
			return new ResponseEntity<Object>(new Object() {
				public int orderID
				= orderService.save(orderDTO);
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping(value = "changeStatusDelivery/{orderID}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> changeStatusDelivery(@PathVariable("orderID") int orderID){
		try {
			return new ResponseEntity<Object>(new Object() {
				public boolean status
				= orderService.changeStatusDelivery(orderID);
				public String message = status ? "Xác nhận đã giao hàng thành công!" : "Giao hàng thất bại";
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping(value = "findByUserID/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDTO>> findByUserID(@PathVariable("id") int id){
		try {
			return new ResponseEntity<List<OrderDTO>>(orderService.findByUserID(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<OrderDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping(value = "findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDTO>> findAll(){
		try {
			return new ResponseEntity<List<OrderDTO>>(orderService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<OrderDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
