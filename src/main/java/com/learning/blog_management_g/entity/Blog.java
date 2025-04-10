package com.learning.blog_management_g.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.blog_management_g.constants.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;

    private String description;

    @OneToMany(mappedBy = "blog")
    @JsonIgnore
    private List<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    private Status status;
}
