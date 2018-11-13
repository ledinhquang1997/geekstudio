package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Course.*;
import com.codingmanstudio.courses.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping({"/all"})
    @ResponseStatus(HttpStatus.OK)
    public ListCourseDTO getAllCourse(){
        return courseService.getAllCourses();
    }

    @GetMapping({"/bestsellers"})
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getBestSellers(){
        return courseService.getBestSellerCourse();
    }

    @GetMapping({"/top-by-category/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getCoursesByCategoryId(@PathVariable String id){
        return courseService.getCourseByCategoryId(id);
    }

    @GetMapping({"/toprating"})
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getTopRatingCourses(){
        return courseService.getTopRatingCourse();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseDetailDTO getCourseById(@PathVariable String id){
        return courseService.getCourseById(id);
    }

    @GetMapping({"/by-category-filter-page/{category}/{filter}/{page}","/courses/by-category/{category}/{filter}/{page}/"})
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getCoursesByCategoryFilterPage(@PathVariable String category,
                                                          @PathVariable String filter,
                                                          @PathVariable int page){
        System.out.println(category+" "+filter+" "+page);
        return courseService.getCoursesByCategoryFilterPage(category,filter,page);
    }

    @GetMapping("/with-lessons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseWithLessonsDTO getCourseWithLessons (@PathVariable String id){
        return courseService.getCourseWithLessons(id);
    }

}
