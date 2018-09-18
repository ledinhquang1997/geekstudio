package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.ListCourseDTO;
import com.codingmanstudio.courses.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping({"/courses/"})
    @ResponseStatus(HttpStatus.OK)
    public ListCourseDTO getAllCourse(){
        return new ListCourseDTO(courseService.getAllCourses());
    }
}
