package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseDetailDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseWithoutInstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.Create.CourseCreateDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentWithoutCourseDTO;
import com.codingmanstudio.courses.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/management/course")
public class CourseManagementController {

    private final CourseService courseService;

    public CourseManagementController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping({"/all", "/all/"})
    public List<CourseWithoutInstructorDTO> getListCourse() {
        return courseService.getListCourseManagement();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping({"/create", "/create/"})
    public CourseDetailDTO createCourse(@RequestBody CourseCreateDTO courseCreateDTO) {
        return courseService.createCourse(courseCreateDTO);
    }

}