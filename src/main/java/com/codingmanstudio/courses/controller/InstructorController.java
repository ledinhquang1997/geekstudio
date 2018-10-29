package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorWithCourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.ListInstructorDTO;
import com.codingmanstudio.courses.services.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "instructors")
@CrossOrigin
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping({"/",""})
    @ResponseStatus(HttpStatus.OK)
    public ListInstructorDTO getAllInstructor(){
        return new ListInstructorDTO(instructorService.getAllInstructors());
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public InstructorDTO getInstructor(@PathVariable String username){
        return instructorService.getInstructor(username);
    }

    @GetMapping("/{username}/{page}")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDTO> getInstructor(@PathVariable String username, @PathVariable int page){
        return instructorService.getCourses(username,page);
    }

}
