package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseDetailDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.ListCourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.StudentCourseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface CourseService {
    ListCourseDTO getAllCourses();
    List<CourseDTO> getBestSellerCourse();
    List<CourseDTO> getCourseByCategoryId(String id);
    List<CourseDTO> getTopRatingCourse();
    List<CourseDTO> getCoursesByCategoryFilterPage(String category, String filter, int page);
    CourseDetailDTO getCourseById(String id);
    List<StudentCourseDTO> getCoursesOfStudent(String username);
}
