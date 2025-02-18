package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.entities.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{

}
