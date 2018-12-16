package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseDetailDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseStatisticDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseWithoutInstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.Create.CourseCreateDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.Update.CourseUpdateDTO;
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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping({"/update", "/update/"})
    public CourseDetailDTO updateCourse(@RequestBody CourseUpdateDTO courseUpdateDTO) {
        return courseService.updateCourse(courseUpdateDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{courseId}")
    public void deleteCourse(@PathVariable String courseId) {
        courseService.deleteCourse(courseId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/statistic")
    public List<CourseStatisticDTO> getCourseStatistic() {
        return courseService.getCourseStatistic();
    }
}
