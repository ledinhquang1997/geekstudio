package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.Student.StudentCreateDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentWithoutCourseDTO;
import com.codingmanstudio.courses.domain.Student;

public interface StudentMapper {
    StudentDTO studentToStudentDto(Student student);
    StudentWithoutCourseDTO studentToStudentWithoutCourseDto(Student student);
    Student studentCreateDTOToStudent(StudentCreateDTO studentCreatedDTODTO);

}
