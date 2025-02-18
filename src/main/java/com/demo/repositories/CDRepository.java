package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Cd;
import com.demo.entities.Genre;
import com.demo.entities.Photo;

public interface CDRepository extends CrudRepository<Cd, Integer>{
	@Query("from Cd where genre.id = :id") //HQL
	public List<Cd> findByGenreId(@Param("id") int id);
}
