package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findByNameOrId(String name, String id);
    Optional<Category> findByName(String name);
}
