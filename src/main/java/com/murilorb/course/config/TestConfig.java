package com.murilorb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.murilorb.course.entities.Order;
import com.murilorb.course.entities.User;
import com.murilorb.course.entities.enums.OrderStatus;
import com.murilorb.course.repositories.OrderRepository;
import com.murilorb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Gilberto Santos", "gilberto@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Larissa Alencar", "larissa@gmail.com", "977777777", "123456");

		Order order1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), user1, OrderStatus.PAID);
		Order order2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"), user2, OrderStatus.WAITING_PAYMENT);
		Order order3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"), user1, OrderStatus.WAITING_PAYMENT);

		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
	}

}
