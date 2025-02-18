package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.Genre;

public interface GenreRepository extends CrudRepository<Genre, Integer>{

}
