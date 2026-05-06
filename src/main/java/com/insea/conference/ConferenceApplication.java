package com.insea.conference;

import com.insea.conference.domain.User;
import com.insea.conference.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConferenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceApplication.class, args);
    }

    // Ce Bean génère un administrateur au lancement de l'application
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            User existingUser = userRepository.findByEmail("admin@conference.com");

            if (existingUser == null) {
                User admin = new User();
                admin.setName("Administrateur");
                admin.setEmail("admin@conference.com");
                admin.setPassword("admin123");
                admin.setRole("ADMIN");
                userRepository.save(admin);
            }
        };
    }
}