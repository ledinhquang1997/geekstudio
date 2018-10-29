package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.api.v1.mapper.InstructorMapper;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.domain.Instructor;
import com.codingmanstudio.courses.exceptions.ResourceNotFoundException;
import com.codingmanstudio.courses.repository.CourseRepository;
import com.codingmanstudio.courses.repository.InstructorRepository;
import com.codingmanstudio.courses.services.InstructorService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;
    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository, InstructorMapper instructorMapper, CourseMapper courseMapper, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
        this.courseMapper = courseMapper;
        this.courseRepository = courseRepository;
    }


    @Override
    public List<InstructorDTO> getAllInstructors() {
        return instructorRepository.findAll()
                .stream()
                .map(instructorMapper::instructorToInstructorDto)
                .collect(Collectors.toList());
    }

    @Override
    public InstructorDTO getInstructor(String username) {
        Optional<Instructor> optionalInstructor = instructorRepository.findByUsername(username);
        if (!optionalInstructor.isPresent()) {
            throw new ResourceNotFoundException("Instructor " + username + " not found");
        }
        Instructor foundInstructor = optionalInstructor.get();

        //Set pageable
        Pageable pageable = PageRequest.of(0,4);

        //create page
        Page<Course> coursesPage = new PageImpl<>(foundInstructor.getCourses().stream().collect(Collectors.toList()),pageable,foundInstructor.getCourses().size());

        InstructorDTO instructorDTO= instructorMapper.instructorToInstructorDto(foundInstructor);
        instructorDTO.setTotalPage(coursesPage.getTotalPages());
        return instructorDTO;
    }

    @Override
    public List<CourseDTO> getCourses(String username, int page) {
        Optional<Instructor> optionalInstructor = instructorRepository.findByUsername(username);
        if (!optionalInstructor.isPresent()) {
            throw new ResourceNotFoundException("Instructor " + username + " not found");
        }
        Instructor foundInstructor = optionalInstructor.get();
        Pageable pageable = PageRequest.of(page, 4, Sort.Direction.DESC,"amountStudent");
        return courseRepository.findByInstructors(foundInstructor,pageable).stream()
                .map(courseMapper::courseToCourseDto)
                .collect(Collectors.toList());

    }
}
