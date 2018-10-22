package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorWithCourseDTO;
import com.codingmanstudio.courses.api.v1.mapper.InstructorMapper;
import com.codingmanstudio.courses.domain.Instructor;
import com.codingmanstudio.courses.exceptions.ResourceNotFoundException;
import com.codingmanstudio.courses.repository.InstructorRepository;
import com.codingmanstudio.courses.services.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    public InstructorServiceImpl(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }


    @Override
    public List<InstructorDTO> getAllInstructors() {
        return instructorRepository.findAll()
                .stream()
                .map(instructorMapper::instructorToInstructorDto)
                .collect(Collectors.toList());
    }

    @Override
    public InstructorWithCourseDTO getInstructor(String instructorName) {
        Optional<Instructor> optionalInstructor = instructorRepository.findByUsername(instructorName);
        if (!optionalInstructor.isPresent()) {
            throw new ResourceNotFoundException("Instructor " + instructorName + " not found");
        }
        Instructor foundInstructor = optionalInstructor.get();
        return instructorMapper.instructorToInstructorWithCourseDTO(foundInstructor);
    }
}
