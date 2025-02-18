package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Integer>{

}
