package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.InstructorDTO;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.domain.Instructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class CourseMapperImpl implements CourseMapper {
    @Override
    public CourseDTO courseToCourseDto(Course course) {
        if (course == null) {
            return null;
        } else {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(course.getId());
            courseDTO.setName(course.getName());
            courseDTO.setDescription(course.getDescription());
            courseDTO.setCost(course.getCost());
            courseDTO.setRating(course.getRating());
            courseDTO.setImage(course.getImage());
            courseDTO.setInstructors(this.instructorSetToInstructorDTOSet(course.getInstructors()));
            return courseDTO;
        }
    }

    private InstructorDTO instructorToInstructorDTO(Instructor instructor){
        if(instructor ==null) return null;
        InstructorDTO instructorDTO = new InstructorDTO();
        instructorDTO.setId(instructor.getId());
        instructorDTO.setCompany(instructor.getCompany());
        instructorDTO.setEmail(instructor.getEmail());
        instructorDTO.setName(instructor.getName());
        instructorDTO.setImage(instructor.getImage());
        instructorDTO.setQuote(instructor.getQuote());
        return  instructorDTO;
    }

    private Set<InstructorDTO> instructorSetToInstructorDTOSet(Set<Instructor> instructors){
        if(instructors==null) return null;
        return instructors.stream()
                .map(this::instructorToInstructorDTO)
                .collect(Collectors.toSet());
    }
}
