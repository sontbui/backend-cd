package com.demo.services;

import java.util.List;

import com.demo.DTO.OrderDTO;

public interface OrderService {
	public int save(OrderDTO orderDTO);
	public List<OrderDTO> findByUserID(int userID);
	public List<OrderDTO> findAll();
	public boolean changeStatusDelivery(int orderID);
}
