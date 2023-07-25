package com.example.demo.util;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository; // Inject your repository or service here

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Write your insert statements using the repository or service
        User user1 = new User();
        user1.setId(1);
        user1.setName("John");
        user1.setEmail("John@j.com");

        User user2 = new User();
        user2.setId(2);
        user2.setName("Jane");
        user2.setEmail("Jane@j.com");
        userRepository.save(user1);
        userRepository.save(user2);
        // Insert more data as needed
    }
}
