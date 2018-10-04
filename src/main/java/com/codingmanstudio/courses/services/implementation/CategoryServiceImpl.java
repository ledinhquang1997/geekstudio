package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.CategoryDTO;
import com.codingmanstudio.courses.api.v1.mapper.CategoryMapper;
import com.codingmanstudio.courses.repository.CategoryRepository;
import com.codingmanstudio.courses.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
   private final CategoryRepository categoryRepository;
   private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDto).collect(Collectors.toList());
    }
}
