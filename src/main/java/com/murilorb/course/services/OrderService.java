package com.murilorb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilorb.course.entities.Order;
import com.murilorb.course.entities.OrderItem;
import com.murilorb.course.entities.Payment;
import com.murilorb.course.entities.enums.OrderStatus;
import com.murilorb.course.repositories.OrderItemRepository;
import com.murilorb.course.repositories.OrderRepository;
import com.murilorb.course.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Order insert(Order obj) {
		obj.setId(null);
		obj.setClient(userService.findById(obj.getClient().getId()));
		obj.setOrderStatus(OrderStatus.WAITING_PAYMENT);
		obj.setPayment(new Payment());
		obj.getPayment().setOrder(obj);
		obj.getPayment().setMoment(null);
		obj = repository.save(obj);

		for (OrderItem item : obj.getItems()) {
			item.setProduct(productService.findById(item.getProduct().getId()));
			item.setPrice(item.getProduct().getPrice());
			item.setOrder(obj);
		}
		orderItemRepository.saveAll(obj.getItems());
		return obj;
	}

}
