package com.user_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.user_service.entity.User;
import com.user_service.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Value("${admin.name}")
	private String adminName;

	@Value("${admin.role}")
	private String adminRole;

	@Value("${admin.email}")
	private String adminEmail;

	@Value("${admin.password}")
	private String adminPassword;

	@Override
	public void run(String... args) throws Exception {
		User adminUser = userRepository.findByUserEmail(adminEmail);
		if(adminUser == null) {
			adminUser = User.builder()
					.name(adminName)
					.userEmail(adminEmail)
					.role(adminRole)
					.password(passwordEncoder.encode(adminPassword))
					.build();
			userRepository.save(adminUser);
		}

	}

}
