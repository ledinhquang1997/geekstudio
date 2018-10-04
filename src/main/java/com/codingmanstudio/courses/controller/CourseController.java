package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.ListCourseDTO;
import com.codingmanstudio.courses.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping({"/courses/"})
    @ResponseStatus(HttpStatus.OK)
    public ListCourseDTO getAllCourse(){
        return courseService.getAllCourses();
    }

    @GetMapping({"/courses/bestsellers"})
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getBestSellers(){
        return courseService.getBestSellerCourse();
    }

    @GetMapping({"/courses/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getCoursesByCategoryId(@PathVariable String id){
        return courseService.getCourseByCategoryId(id);
    }

    @GetMapping({"/courses/toprating"})
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getTopRatingCourses(){
        return courseService.getTopRatingCourse();
    }
}
