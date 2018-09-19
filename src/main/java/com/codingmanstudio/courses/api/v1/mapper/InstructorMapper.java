package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.InstructorDTO;
import com.codingmanstudio.courses.domain.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InstructorMapper  {
    InstructorMapper INSTANCE = Mappers.getMapper(InstructorMapper.class);

    InstructorDTO instructorToInstructorDto(Instructor instructor);
}
