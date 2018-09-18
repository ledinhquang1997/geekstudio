package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstructorRepository extends JpaRepository<Instructor, String> {
}
