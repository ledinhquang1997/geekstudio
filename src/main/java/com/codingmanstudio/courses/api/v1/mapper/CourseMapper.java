package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.CourseDTO;
import com.codingmanstudio.courses.domain.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface CourseMapper {

    CourseDTO courseToCourseDto(Course course);
}
