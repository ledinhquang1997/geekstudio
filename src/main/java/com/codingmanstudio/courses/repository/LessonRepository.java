package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,String> {
}
