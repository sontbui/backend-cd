package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.DTO.ArtistDTO;
import com.demo.DTO.ChatDTO;
import com.demo.entities.Chat;
import com.demo.services.ArtistService;
import com.demo.services.ChatService;

@Controller
@RequestMapping("api/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping(value = "findByID/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtistDTO> findByID(
            @PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<ArtistDTO>(artistService.findByID(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ArtistDTO>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "findAll", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistDTO>> findAll() {
        try {
            return new ResponseEntity<List<ArtistDTO>>(artistService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<ArtistDTO>>(HttpStatus.BAD_REQUEST);
        }
    }
    
	@PutMapping(value = "update", produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> checkLogin(@RequestBody ArtistDTO artistDTO){
		try {
			return new ResponseEntity<Object>(new Object() {
				public boolean status = artistService.save(artistDTO);
			}, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
   


}
