package com.demo.services;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DTO.OrderDTO;
import com.demo.DTO.UserDTO;
import com.demo.entities.Order;
import com.demo.entities.User;
import com.demo.repositories.GenreRepository;
import com.demo.repositories.OrderRepository;
import com.demo.repositories.UserRepository;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper mapper;
	@Override
	public int save(OrderDTO orderDTO) {
		try {
			Order order = mapper.map(orderDTO, Order.class);
			User user = userRepository.findById(orderDTO.getUserID()).get();
			order.setUser(user);
			order.setOrderDate(new Date());
			
			return orderRepository.save(order).getId();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public List<OrderDTO> findByUserID(int userID) {
		return mapper.map(orderRepository.findByUserID(userID), new TypeToken<List<OrderDTO>>() {}.getType());
	}
	@Override
	public List<OrderDTO> findAll() {
		return mapper.map(orderRepository.findAll(), new TypeToken<List<OrderDTO>>() {}.getType());
	}
	@Override
	public boolean changeStatusDelivery(int orderID) {
		Order order = orderRepository.findById(orderID).get();
		if(order.getStatus() == 2) {
			order.setStatus(3);
			orderRepository.save(order);
			return true;
		} else {
			return false;
		}

	}

}
