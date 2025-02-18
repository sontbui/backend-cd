package com.demo.services;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DTO.OrderDTO;
import com.demo.DTO.OrderDetailsDTO;
import com.demo.entities.Cd;
import com.demo.entities.Order;
import com.demo.entities.Orderdetails;
import com.demo.entities.User;
import com.demo.repositories.CDRepository;
import com.demo.repositories.GenreRepository;
import com.demo.repositories.OrderDetailsRepository;
import com.demo.repositories.OrderRepository;
import com.demo.repositories.UserRepository;
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	@Autowired
	private CDRepository cdRepository;
	@Autowired
	private ModelMapper mapper;
	@Override
	public boolean save(OrderDetailsDTO orderDetailsDTO) {
		try {
			Orderdetails orderDetails = mapper.map(orderDetailsDTO, Orderdetails.class);
			Cd cd = cdRepository.findById(orderDetailsDTO.getCdID()).get();
			Order order = orderRepository.findById(orderDetailsDTO.getOrderID()).get();
			orderDetails.setCd(cd);
			orderDetails.setOrder(order);
			
			orderDetailsRepository.save(orderDetails);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<OrderDetailsDTO> findByOrderID(int id) {
		return mapper.map(orderDetailsRepository.findByOrderID(id), new TypeToken<List<OrderDetailsDTO>>() {}.getType());
	}

}
