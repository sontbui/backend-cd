package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Cd;
import com.demo.entities.Genre;
import com.demo.entities.Photo;
import com.demo.entities.User;

public interface PhotoRepository extends CrudRepository<Photo, Integer>{
	@Query("from Photo where cd.id = :id") //HQL
	public List<Photo> findByCDId(@Param("id") int id);
}
