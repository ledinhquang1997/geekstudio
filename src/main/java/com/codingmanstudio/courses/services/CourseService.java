package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.Course.*;
import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonWithSectionsDTO;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.domain.Lesson;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface CourseService {
    ListCourseDTO getAllCourses();
    List<CourseDTO> getBestSellerCourse();
    List<CourseDTO> getCourseByCategoryId(String id);
    List<CourseDTO> getTopRatingCourse();
    List<CourseDTO> getCoursesByCategoryFilterPage(String category, String filter, int page);
    CourseDetailDTO getCourseById(String id);
    List<StudentCourseDTO> getCoursesOfStudent(String username);
    StudentCourseWithLessonsDTO getStudentCourseWithLessons(String username,String courseId);
    LessonWithSectionsDTO getLessonWithSections(String lessonId);
}
