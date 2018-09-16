package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lessons, UUID> {
}
