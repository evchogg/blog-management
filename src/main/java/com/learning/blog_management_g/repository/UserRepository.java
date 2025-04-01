package com.learning.blog_management_g.repository;


import com.learning.blog_management_g.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
