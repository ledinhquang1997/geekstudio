package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryWithCoursesDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryWithTopicsDTO;
import com.codingmanstudio.courses.domain.Category;

public interface CategoryMapper {

    CategoryDTO categoryToCategoryDto(Category category);
    CategoryWithCoursesDTO categoryToCategoryWithCoursesDto(Category category);
    CategoryWithTopicsDTO categoryToCategoryWithTopicsDto(Category category);
}
