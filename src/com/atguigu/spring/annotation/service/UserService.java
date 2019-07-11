package com.atguigu.spring.annotation.service;


import com.atguigu.spring.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    public void add() {


        System.out.println("UserService add....");
        userRepository.save();
    }
}
