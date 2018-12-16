package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryStatisticDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryWithCoursesDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryWithTopicsDTO;
import com.codingmanstudio.courses.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RequestMapping("/category")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping({"/",""})
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/with-courses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryWithCoursesDTO getCategoryWithCourses(@PathVariable String id){
        return categoryService.getCategoryWithCourses(id);
    }

    @GetMapping("/with-topics/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryWithTopicsDTO getCategoryWithTopics(@PathVariable String id){
        return categoryService.getCategoryWithTopicsDto(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @GetMapping("/statistic")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryStatisticDTO> getCategoryStatistic(){
        return categoryService.getCategoryStatistics();
    }
}
