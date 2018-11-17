package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.Student.StudentCreatedDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.domain.Student;

public interface StudentMapper {
    StudentDTO studentToStudentDto(Student student);

    Student studentDTOToStudent(StudentCreatedDTO studentCreatedDTODTO);
}
