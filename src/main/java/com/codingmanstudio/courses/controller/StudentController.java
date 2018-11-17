package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Student.StudentCreatedDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentUpdatedDTO;
import com.codingmanstudio.courses.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO addStudent(@RequestBody StudentCreatedDTO studentCreatedDTO){
        return studentService.addStudent(studentCreatedDTO);
    }

    @PatchMapping("/update/{username}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO updateStudent(@RequestBody StudentUpdatedDTO studentUpdatedDTO){
        return studentService.updateStudent(studentUpdatedDTO);
    }
}
