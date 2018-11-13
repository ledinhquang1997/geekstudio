package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Course.StudentCourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.StudentCourseWithLessonsDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.Update.ProgressDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.StudentLessonWithSectionsDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.domain.Student;
import com.codingmanstudio.courses.services.AccountService;
import com.codingmanstudio.courses.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/user")
@RestController
public class AccountController {
    private final AccountService accountService;
    private final CourseService courseService;

    public AccountController(AccountService accountService, CourseService courseService) {
        this.accountService = accountService;
        this.courseService = courseService;
    }

    @GetMapping({"/{username}"})
    @ResponseStatus(HttpStatus.OK)
    public Object getUserinfo(@PathVariable String username){
        return accountService.getUserInfo(username);
    }

    @GetMapping({"/loginsuccess"})
    @ResponseStatus(HttpStatus.OK)
    public void getUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
    }

    @GetMapping("/student/{username}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO getStudent(@PathVariable String username){
        return accountService.getCurrentStudent(username);
    }


    @GetMapping("/addcourse/{username}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO addCourse(@PathVariable String username){
        return accountService.addCourse(username);
    }

    @GetMapping("/addprogress/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void addprogress(@PathVariable String username){
         accountService.addprogress(username);
    }

    @GetMapping("/courses/{username}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentCourseDTO> getCoursesOfStudent(@PathVariable String username){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        return courseService.getCoursesOfStudent(username);
    }
    @GetMapping("/course-lessons/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public StudentCourseWithLessonsDTO getStudentCourseWithLessons(@PathVariable String courseId){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return courseService.getStudentCourseWithLessons( userDetails.getUsername(),  courseId);
    }

    @GetMapping("/lesson-sections/{lessonId}")
    @ResponseStatus(HttpStatus.OK)
    public StudentLessonWithSectionsDTO getLessonDtail(@PathVariable String lessonId){
        return courseService.getLessonWithSections(lessonId);
    }

    @GetMapping("/section/{sectionId}")
    @ResponseStatus(HttpStatus.OK)
    public SectionDTO getSectionDetail(@PathVariable String sectionId){
        return courseService.getSectionDetail(sectionId);
    }


    @PatchMapping({"/progress","/progress/"})
    @ResponseStatus(HttpStatus.OK)
    public StudentCourseDTO changeProgress(@RequestBody ProgressDTO progressDTO){
        return courseService.changeProgress(progressDTO);
    }
}
