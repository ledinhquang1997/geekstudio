package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.Student.StudentCreatedDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentUpdatedDTO;

public interface StudentService {

   StudentDTO addStudent(StudentCreatedDTO studentCreatedDTO);

   StudentDTO updateStudent(StudentUpdatedDTO studentUpdatedDTO);
}
