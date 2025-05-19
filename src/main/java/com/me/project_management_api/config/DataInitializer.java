package com.me.project_management_api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.me.project_management_api.entity.UserEntity;
import com.me.project_management_api.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String username = "admin";
            String password = "admin";

            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(username);
            userEntity.setPassword(passwordEncoder.encode(password));

            userRepository.save(userEntity);
            System.out.println("El usuario " + userEntity.getUsername() + "ha sido creado.");
        };
    }
}
