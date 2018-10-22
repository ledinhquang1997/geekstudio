package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorWithCourseDTO;

import java.util.List;

public interface InstructorService {
    List<InstructorDTO> getAllInstructors();

    InstructorWithCourseDTO getInstructor(String instructorName);
}
