package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.DTO.DeliveryInfoDTO;
import com.demo.entities.Cd;
import com.demo.entities.DeliveryInfo;
import com.demo.entities.Genre;
import com.demo.entities.Photo;
import com.demo.entities.User;

public interface DeliveryInfoRepository extends CrudRepository<DeliveryInfo, Integer>{
	@Query("from DeliveryInfo where user.id = :id") //HQL
	public List<DeliveryInfo> findByUserId(@Param("id") Integer id);
}
