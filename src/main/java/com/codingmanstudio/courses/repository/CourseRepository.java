package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Courses, UUID> {
}
