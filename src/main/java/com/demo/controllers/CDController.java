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

import com.demo.DTO.CDDTO;
import com.demo.DTO.GenreDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.Cd;
import com.demo.entities.Genre;
import com.demo.entities.User;
import com.demo.repositories.GenreRepository;
import com.demo.services.CDService;
import com.demo.services.GenreService;
import com.demo.services.UserService;
@Controller

@RequestMapping("api/cd")




public class CDController {
	@Autowired
	private CDService cdService;
	@GetMapping(value = "findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Cd>> findAll(){
		try {
			return new ResponseEntity<Iterable<Cd>>(cdService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Iterable<Cd>>(HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping(value = "update", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody CDDTO cddto){
		try {
			return new ResponseEntity<Object>(new Object() {
				public boolean status = cdService.save(cddto);
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping(value = "create", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody CDDTO cddto){
		try {
			return new ResponseEntity<Object>(new Object() {
				public boolean status = cdService.save(cddto);
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping(value = "findById/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<CDDTO> findByUsername(@PathVariable("id") int id){
		try {
			return new ResponseEntity<CDDTO>(cdService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<CDDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping(value = "findByGenreId/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cd>> findByGenreId(@PathVariable("id") int id){
		try {
			return new ResponseEntity<List<Cd>>(cdService.findByGenreId(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Cd>>(HttpStatus.BAD_REQUEST);
		}
	}
}
