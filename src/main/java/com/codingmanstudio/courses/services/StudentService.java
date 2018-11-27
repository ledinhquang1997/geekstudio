package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.Student.StudentCreateDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentWithoutCourseDTO;
import com.codingmanstudio.courses.domain.Student;

import java.util.List;

public interface StudentService {
    List<StudentWithoutCourseDTO> getListStudents();
    StudentDTO createStudent(StudentCreateDTO studentCreateDTO);
}
