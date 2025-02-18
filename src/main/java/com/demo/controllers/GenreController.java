package com.demo.controllers;

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
import com.demo.DTO.UserDTO;
import com.demo.entities.Genre;
import com.demo.entities.User;
import com.demo.repositories.GenreRepository;
import com.demo.services.GenreService;
import com.demo.services.UserService;
@Controller

@RequestMapping("api/genre")




public class GenreController {
	@Autowired
	private GenreService genreService;
	@GetMapping(value = "findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Genre>> findAll(){
		try {
			return new ResponseEntity<Iterable<Genre>>(genreService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Iterable<Genre>>(HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping(value = "update", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> checkLogin(@RequestBody GenreDTO genreDTO){
		try {
			return new ResponseEntity<Object>(new Object() {
				public boolean status = genreService.save(genreDTO);
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
//	@GetMapping(value = "findByUsername/{username}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<UserDTO> findByUsername(@PathVariable("username") String username){
//		try {
//			return new ResponseEntity<UserDTO>(userService.findByUsername(username), HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
//		}
//	}
}
