package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Student;
import com.codingmanstudio.courses.domain.StudentCourse;
import com.codingmanstudio.courses.domain.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, StudentCourseId> {
    List<StudentCourse> findAllByStudentUsername(String username);
    StudentCourse findByStudentUsernameAndCourseName(String username,String courseName);
    Optional<StudentCourse> findByStudentUsernameAndCourseId(String username, String courseId);
}
