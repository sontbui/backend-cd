package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Cd;
import com.demo.entities.Genre;
import com.demo.entities.Order;
import com.demo.entities.Orderdetails;
import com.demo.entities.Photo;

public interface OrderDetailsRepository extends CrudRepository<Orderdetails, Integer>{
	@Query("from Orderdetails where order.id = :id") //HQL
	public List<Orderdetails> findByOrderID(@Param("id") int id);
}
