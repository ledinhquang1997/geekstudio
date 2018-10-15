package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Instructor.ListInstructorDTO;
import com.codingmanstudio.courses.services.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
