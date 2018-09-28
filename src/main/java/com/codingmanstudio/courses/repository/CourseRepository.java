package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, String> {
    Optional<Course> findByName(String name);

    List<Course> findTop6ByOrderByAmountStudentDesc();
}
