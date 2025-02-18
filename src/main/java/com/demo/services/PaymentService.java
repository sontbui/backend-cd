package com.demo.services;

import java.util.List;

import com.demo.DTO.PaymentDTO;

public interface PaymentService {
	public boolean save(PaymentDTO paymentDTO);
	public List<PaymentDTO> findAll();
}
