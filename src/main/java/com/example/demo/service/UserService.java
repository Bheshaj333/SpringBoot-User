package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getRandomUser(){
        User user = new User();
        Random random = new Random();
        user.setId(random.nextInt(30));
        user.setName("Bheshaj");
        user.setEmail("bss@gmail.com");
//        userRepository.save(user);
//        System.out.println(demo);
        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

     public boolean setUser(User user){
        try{
            userRepository.save(user);
            return true;
        }catch (Exception e){
            System.out.println("Error in saving user " + e.getMessage());
            return false;
        }
    }

    public boolean updateUsingSaveMethod(int id){
        try{
            Optional<User> user = userRepository.findById(id);
            User user2 = new User();
            user2.setId(25);
            user2.setName("updateUsingSaveMethod");
            user2.setEmail("updateUsingSaveMethod@gmail.com");
            userRepository.save(user2);

            userRepository.updateUserByName("BheshajSinghShekhawat", 25);
        } catch (Exception e){
            System.out.println("Error in saving user " + e.getMessage());
        }
        return false;
    }
}
