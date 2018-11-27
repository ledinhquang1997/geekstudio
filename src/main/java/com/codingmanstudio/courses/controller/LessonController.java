package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Course.ListCourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonWithDetailedSectionsDTO;
import com.codingmanstudio.courses.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/lesson")
public class LessonController {
    private final CourseService courseService;

    public LessonController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public LessonWithDetailedSectionsDTO getLessonWithSections(@PathVariable String id){
        return courseService.getLessonWithDetailedSections(id);
    }


}
