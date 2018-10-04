package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
}
