package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorWithCourseDTO;
import com.codingmanstudio.courses.domain.Instructor;

public interface InstructorMapper {
    InstructorDTO instructorToInstructorDto(Instructor instructor);

    InstructorWithCourseDTO instructorToInstructorWithCourseDTO(Instructor instructor);
}
