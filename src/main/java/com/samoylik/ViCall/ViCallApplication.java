package com.samoylik.ViCall;

import com.samoylik.ViCall.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.samoylik.ViCall.user.User;

@SpringBootApplication
public class ViCallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViCallApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserService service) {
		return (args) -> {
			service.registerUser(User.builder()
					.name("Vasiliy Samoylik")
					.email("vasya.samoylik@gmail.com")
					.password("123456")
					.build());
			service.registerUser(User.builder()
					.name("Ivan Ivanov")
					.email("ivan.ivanov@gmail.com")
					.password("123456")
					.build());
		};
	}

}
