package com.learning.blog_management_g.service;


import com.learning.blog_management_g.constants.EmailValidator;
import com.learning.blog_management_g.constants.ErrorType;
import com.learning.blog_management_g.entity.User;
import com.learning.blog_management_g.entity_dto.UserDTO;
import com.learning.blog_management_g.exceptions.UserException;
import com.learning.blog_management_g.mapper.UserMapper;
import com.learning.blog_management_g.repository.UserRepository;
import com.learning.blog_management_g.specification.GenericSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toUserDTO).toList();
    }

    public List<UserDTO> searchUsers(Map<String, String> searchParams) {
        Specification<User> spec = new GenericSpecification<>(searchParams);
        return userRepository.findAll(spec).stream()
                .map(UserMapper.INSTANCE::toUserDTO).toList();
    }

    public void deleteUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserException(ErrorType.NOT_FOUND, "User not found with id:"+ id));
        userRepository.deleteById(id);
    }

}
