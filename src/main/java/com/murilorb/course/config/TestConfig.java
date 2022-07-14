package com.murilorb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.murilorb.course.entities.User;
import com.murilorb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Gilberto Santos", "gilberto@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Larissa Alencar", "larissa@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
	}

}
