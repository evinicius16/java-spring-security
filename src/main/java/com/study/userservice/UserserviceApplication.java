package com.study.userservice;

import com.study.userservice.enums.RoleEnum;
import com.study.userservice.models.Role;
import com.study.userservice.models.User;
import com.study.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, RoleEnum.ROLE_USER.name()));
			userService.saveRole(new Role(null, RoleEnum.ROLE_MANAGER.name()));
			userService.saveRole(new Role(null, RoleEnum.ROLE_ADMIN.name()));
			userService.saveRole(new Role(null, RoleEnum.ROLE_SUPER_ADMIN.name()));

			userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", RoleEnum.ROLE_USER.name());
			userService.addRoleToUser("will", RoleEnum.ROLE_ADMIN.name());
			userService.addRoleToUser("jim", RoleEnum.ROLE_MANAGER.name());
			userService.addRoleToUser("arnold", RoleEnum.ROLE_SUPER_ADMIN.name());
			userService.addRoleToUser("arnold", RoleEnum.ROLE_ADMIN.name());
			userService.addRoleToUser("arnold", RoleEnum.ROLE_USER.name());
		};
	}

}
