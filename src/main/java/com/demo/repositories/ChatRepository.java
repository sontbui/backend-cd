package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.demo.entities.Chat;

public interface ChatRepository extends CrudRepository<Chat, Integer> {
    
    @Query("SELECT c FROM Chat c WHERE c.sender.id = :senderId AND c.receiver.id = :receiverId")
    List<Chat> findListChat(@Param("senderId") Integer senderId, @Param("receiverId") Integer receiverId);
    
    @Query(value = """
    	    SELECT c.*
    	    FROM chat c
    	    INNER JOIN (
    	        SELECT MAX(c2.id) AS last_message_id
    	        FROM chat c2
    	        WHERE c2.receiver_id = :adminId
    	        GROUP BY c2.sender_id
    	    ) subquery ON c.id = subquery.last_message_id
    	    WHERE c.receiver_id = :adminId
    	""", nativeQuery = true)
    	List<Chat> findLastMessagesToAdmin(@Param("adminId") Integer adminId);



}
