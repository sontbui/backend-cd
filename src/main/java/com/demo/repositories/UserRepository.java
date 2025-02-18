package com.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	@Query("from User where username = :username") //HQL

	public User findByUserName(@Param("username") String username);
	
	 Optional<User> findByGoogleId(String googleId);
	 
		@Query("from User where email = :email") //HQL

		public User findByEmail(@Param("email") String email);
}
