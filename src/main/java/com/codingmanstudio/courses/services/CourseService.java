package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourses();
    List<CourseDTO> getBestSellerCourse();
}
