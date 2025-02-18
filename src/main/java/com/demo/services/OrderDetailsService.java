package com.demo.services;

import java.util.List;

import com.demo.DTO.OrderDTO;
import com.demo.DTO.OrderDetailsDTO;

public interface OrderDetailsService {
	public boolean save(OrderDetailsDTO orderDetailsDTO);
	public List<OrderDetailsDTO> findByOrderID(int id);
}
