package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.StudentCourse;
import com.codingmanstudio.courses.domain.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {
}
