package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.ListCourseDTO;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.repository.CourseRepository;
import com.codingmanstudio.courses.services.CourseService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ListCourseDTO getAllCourses() {
        Sort sortable = Sort.by("amountStudent").descending();
        Pageable pageable = PageRequest.of(2,5,sortable);

        Page page = courseRepository.findAll(pageable);
        List<CourseDTO> courseDTOs= courseRepository.findAll(pageable)
                .stream()
                .map(courseMapper::courseToCourseDto)
                .collect(Collectors.toList());

        ListCourseDTO listCourseDTO = new ListCourseDTO();
        listCourseDTO.setCourseDTOList(courseDTOs);
        listCourseDTO.setTotalPage(page.getTotalPages());
        return listCourseDTO;
    }

    @Override
    public List<CourseDTO> getBestSellerCourse() {
        return courseRepository.findTop6ByOrderByAmountStudentDesc().stream()
                .map(courseMapper::courseToCourseDto).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourseByCategoryId(String id) {
        return courseRepository.findTop8ByCategoryIdOrderByAmountStudentDesc(id).stream().map(courseMapper::courseToCourseDto).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getTopRatingCourse() {
        return courseRepository.findTop8ByOrderByRatingDesc().stream().map(courseMapper::courseToCourseDto).collect(Collectors.toList());
    }
}
