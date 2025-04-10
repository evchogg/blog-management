package com.learning.blog_management_g.specification;

import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class GenericSpecification<T> implements Specification<T> {

    private final Map<String, String> filters;

    public GenericSpecification(Map<String, String> filters) {
        this.filters = filters;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        filters.forEach((key, value) -> {
            try {
                if (value != null && !value.isBlank() && hasField(root.getJavaType(), key)) {
                    Path<String> path = root.get(key);
                    predicates.add(cb.like(cb.lower(path), "%" + value.toLowerCase() + "%"));
                }
            } catch (IllegalArgumentException ignored) {
                // Field doesn't exist in entity; skip it
            }
        });

        return cb.and(predicates.toArray(new Predicate[0]));
    }

    private boolean hasField(Class<?> clazz, String fieldName) {
        return Arrays.stream(clazz.getDeclaredFields())
                .anyMatch(field -> field.getName().equals(fieldName));
    }
}

