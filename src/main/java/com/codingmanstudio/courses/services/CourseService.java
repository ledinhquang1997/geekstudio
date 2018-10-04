package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.ListCourseDTO;

import java.util.List;

public interface CourseService {
    ListCourseDTO getAllCourses();
    List<CourseDTO> getBestSellerCourse();
    List<CourseDTO> getCourseByCategoryId(String id);
    List<CourseDTO> getTopRatingCourse();

}
