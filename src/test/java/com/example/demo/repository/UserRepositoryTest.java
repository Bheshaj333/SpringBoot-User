package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DataJpaTest
class UserRepositoryTest {

    @Mock
    private UserRepository userRepository; // Mocking the UserRepository

    @InjectMocks
    private UserService userService; // Injecting the UserService which uses the UserRepository

    @Test
    public void testUpdateUserByName() {
        // Create a sample user ID and name
        int userId = 1;
        String newName = "John Doe";

        // Mock the UserRepository's updateUserByName method
        doNothing().when(userRepository).updateUserByName(newName, userId);

        // Perform the update operation
        userRepository.updateUserByName(newName, userId);

        // Verify that the updateUserByName method was called with the correct arguments
        verify(userRepository).updateUserByName(newName, userId);

        // Assert that the update was successful (no exceptions were thrown)
        // You can add additional assertions here based on your requirements
//        assertEquals(1, 1);
    }

}