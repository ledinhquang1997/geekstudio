package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorWithCourseDTO;

import java.util.List;
import java.util.Set;

public interface InstructorService {
    List<InstructorDTO> getAllInstructors();

    InstructorDTO getInstructor(String username);
    List<CourseDTO> getCourses(String username, int page);
}
