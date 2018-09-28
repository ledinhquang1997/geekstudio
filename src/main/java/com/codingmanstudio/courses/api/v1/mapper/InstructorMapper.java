package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.InstructorDTO;
import com.codingmanstudio.courses.domain.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface InstructorMapper {
    InstructorDTO instructorToInstructorDto(Instructor instructor);
}
