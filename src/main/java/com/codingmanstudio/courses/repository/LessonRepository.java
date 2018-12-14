package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson,String> {
    Optional<Lesson> findById(String id);
    List<Lesson> findByCourseIdOrderByOrdinalNumber(String courseId);
}
