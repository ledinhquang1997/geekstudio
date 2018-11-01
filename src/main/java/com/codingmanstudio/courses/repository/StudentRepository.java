package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,String> {
    Optional<Student> findByUsername(String username);
}
