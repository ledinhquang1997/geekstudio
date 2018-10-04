package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.CategoryDTO;
import com.codingmanstudio.courses.services.CategoryService;
import org.springframework.http.HttpStatus;
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

}
