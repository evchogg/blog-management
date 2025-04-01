package com.learning.blog_management_g.service;


import com.learning.blog_management_g.constants.EmailValidator;
import com.learning.blog_management_g.entity.User;
import com.learning.blog_management_g.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        EmailValidator.validateEmail(user.getEmail());

        return userRepository.save(user);

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
