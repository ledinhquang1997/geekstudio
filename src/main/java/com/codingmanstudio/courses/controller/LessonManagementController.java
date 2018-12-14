package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonCreateDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonUpdateDTO;
import com.codingmanstudio.courses.services.CourseService;
import com.codingmanstudio.courses.services.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.TreeSet;

@CrossOrigin
@RestController
@RequestMapping("/management/lesson")
public class LessonManagementController {
    private final CourseService courseService;
    private final LessonService lessonService;

    public LessonManagementController(CourseService courseService, LessonService lessonService) {
        this.courseService = courseService;
        this.lessonService = lessonService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all/{courseId}")
    public TreeSet<LessonDTO> getListLesson(@PathVariable String courseId) {
        return lessonService.getListLesson(courseId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{lessonId}")
    public LessonDTO getLesson(@PathVariable String lessonId) {
        return lessonService.getLesson(lessonId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/")
    public LessonDTO updateLesson(@RequestBody LessonUpdateDTO lessonUpdateDTO) {
        return lessonService.updateLesson(lessonUpdateDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    public LessonDTO createLesson(@RequestBody LessonCreateDTO lessonCreateDTO) {
        return lessonService.createLesson(lessonCreateDTO);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{lessonId}")
    public void deleteLesson(@PathVariable String lessonId) {
        lessonService.deleteLesson(lessonId);
    }


}

