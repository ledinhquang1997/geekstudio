package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.CourseDTO;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.repository.CourseRepository;
import com.codingmanstudio.courses.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::courseToCourseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getBestSellerCourse() {
        return courseRepository.findTop6ByOrderByAmountStudentDesc().stream()
                .map(courseMapper::courseToCourseDto).collect(Collectors.toList());
    }
}
