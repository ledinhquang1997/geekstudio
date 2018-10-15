package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryWithCoursesDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryWithTopicsDTO;
import com.codingmanstudio.courses.api.v1.mapper.CategoryMapper;
import com.codingmanstudio.courses.domain.Category;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.exceptions.ResourceNotFoundException;
import com.codingmanstudio.courses.repository.CategoryRepository;
import com.codingmanstudio.courses.services.CategoryService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Override
    public CategoryWithCoursesDTO getCategoryWithCourses(String id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (!categoryOptional.isPresent()) {
            throw new ResourceNotFoundException("Category " + id + " not found");
        }
        Category foundCategory = categoryOptional.get();
        return categoryMapper.categoryToCategoryWithCoursesDto(foundCategory);
    }

    @Override
    public CategoryWithTopicsDTO getCategoryWithTopicsDto(String id) {
        Optional<Category> categoryOptional = categoryRepository.findByNameOrId(id,id);
        if (!categoryOptional.isPresent()) {
            throw new ResourceNotFoundException("Category " + id + " not found");
        }
        Category foundCategory = categoryOptional.get();
        //Set pageable
        Sort sortable = Sort.by("amountStudent").descending();
        Pageable pageable = PageRequest.of(0,8,sortable);

        //create page
        Page<Course> coursesPage = new PageImpl<>(foundCategory.getCourses().stream().collect(Collectors.toList()),pageable,foundCategory.getCourses().size());

        //convert to DTO
        CategoryWithTopicsDTO returnCategory= categoryMapper.categoryToCategoryWithTopicsDto(foundCategory);

        //Set totalPage
        returnCategory.setTotalPage(coursesPage.getTotalPages());

        return returnCategory;
    }
}
