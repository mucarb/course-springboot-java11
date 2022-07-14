package com.murilorb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.murilorb.course.entities.Category;
import com.murilorb.course.entities.Order;
import com.murilorb.course.entities.Product;
import com.murilorb.course.entities.User;
import com.murilorb.course.entities.enums.OrderStatus;
import com.murilorb.course.repositories.CategoryRepository;
import com.murilorb.course.repositories.OrderRepository;
import com.murilorb.course.repositories.ProductRepository;
import com.murilorb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		cat1.getProducts().add(p2);
		cat2.getProducts().addAll(Arrays.asList(p1, p5));
		cat3.getProducts().addAll(Arrays.asList(p2, p3, p4));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		User user1 = new User(null, "Gilberto Santos", "gilberto@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Larissa Alencar", "larissa@gmail.com", "977777777", "123456");

		Order order1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), user1, OrderStatus.PAID);
		Order order2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"), user2, OrderStatus.WAITING_PAYMENT);
		Order order3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"), user1, OrderStatus.WAITING_PAYMENT);

		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
	}

}
