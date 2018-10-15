package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryWithCoursesDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryWithTopicsDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryWithCoursesDTO getCategoryWithCourses(String id);
    CategoryWithTopicsDTO getCategoryWithTopicsDto(String id);
}
