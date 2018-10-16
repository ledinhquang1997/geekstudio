package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Category;
import com.codingmanstudio.courses.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, String> {
    Optional<Course> findByName(String name);

    List<Course> findTop6ByOrderByAmountStudentDesc();
    List<Course> findTop8ByCategoryIdOrderByAmountStudentDesc(String id);
    List<Course> findTop8ByOrderByRatingDesc();

    Page<Course> findByCategoryId(String categoryId, Pageable pageable);

    Optional<Course> findTopByCategoryIdOrCategoryNameOrderByAmountStudentDesc(String categoryId,String name);
}
