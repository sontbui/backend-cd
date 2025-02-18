package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.DTO.OrderDTO;
import com.demo.DTO.PaymentDTO;
import com.demo.services.OrderService;
import com.demo.services.PaymentService;

@Controller

@RequestMapping("api/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
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
	public ResponseEntity<Object> create(@RequestBody PaymentDTO paymentDTO){
		try {
			System.out.println(paymentDTO);
			return new ResponseEntity<Object>(new Object() {
				public boolean status 
				= paymentService.save(paymentDTO);
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping(value = "findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PaymentDTO>> findAll(){
		try {
			return new ResponseEntity<List<PaymentDTO>>(paymentService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<PaymentDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
}
