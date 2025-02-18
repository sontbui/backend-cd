package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Cd;
import com.demo.entities.Genre;
import com.demo.entities.Order;
import com.demo.entities.Photo;
import com.demo.entities.User;

public interface OrderRepository extends CrudRepository<Order, Integer>{
	@Query("from Order where user.id = :id") //HQL
	public List<Order> findByUserID(@Param("id") int id);
}
