package com.learning.blog_management_g.service;


import com.learning.blog_management_g.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    private BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


}
