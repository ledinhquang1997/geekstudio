package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.ListCourseDTO;
import com.codingmanstudio.courses.services.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @GetMapping({"/courses/by-category/{category}/{filter}/{page}","/courses/by-category/{category}/{filter}/{page}/"})
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getCoursesByCategoryFilterPage(@PathVariable String category,
                                                          @PathVariable String filter,
                                                          @PathVariable int page){
        System.out.println(category+" "+filter+" "+page);
        return courseService.getCoursesByCategoryFilterPage(category,filter,page);
    }
}
