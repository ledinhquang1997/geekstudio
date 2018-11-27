package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Student.StudentCreateDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentWithoutCourseDTO;
import com.codingmanstudio.courses.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/management/student")
public class StudentManagementController {
    private final StudentService studentService;

    public StudentManagementController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping({"/all","/all/"})
    public List<StudentWithoutCourseDTO> getListStudent(){
        return studentService.getListStudents();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public StudentDTO createStudent(@RequestBody StudentCreateDTO studentCreateDTO){
        return studentService.createStudent(studentCreateDTO);
    }

}
