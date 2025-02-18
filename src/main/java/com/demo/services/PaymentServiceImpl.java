package com.demo.services;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DTO.OrderDTO;
import com.demo.DTO.PaymentDTO;
import com.demo.entities.DeliveryInfo;
import com.demo.entities.Order;
import com.demo.entities.Payment;
import com.demo.repositories.DeliveryInfoRepository;
import com.demo.repositories.OrderRepository;
import com.demo.repositories.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired 
	private PaymentRepository paymentRepository;
	@Autowired 
	private ModelMapper mapper;
	@Autowired
	private DeliveryInfoRepository deliveryInfoRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Override
	public boolean save(PaymentDTO paymentDTO) {
		try {
			Payment payment = mapper.map(paymentDTO, Payment.class);
			DeliveryInfo deliveryInfo = deliveryInfoRepository.findById(paymentDTO.getDeliveryInfoID()).get();
			Order order = orderRepository.findById(paymentDTO.getOrderID()).get();
			payment.setDeliveryInfo(deliveryInfo);
			payment.setCreated(new Date());
			
			payment.setOrder(order);
			payment.setStatus(true);
			System.out.println(payment);
			paymentRepository.save(payment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
	
		}
	}
	@Override
	public List<PaymentDTO> findAll() {
		return mapper.map(paymentRepository.findAll(), new TypeToken<List<PaymentDTO>>() {}.getType());
	}

}
