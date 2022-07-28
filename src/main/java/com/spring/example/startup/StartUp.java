package com.spring.example.startup;

import com.spring.example.entities.User;
import com.spring.example.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartUp implements CommandLineRunner {

    private final UserRepository userRepository;

    public StartUp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users=userRepository.findAll();
        System.out.println(users);



    }
}
