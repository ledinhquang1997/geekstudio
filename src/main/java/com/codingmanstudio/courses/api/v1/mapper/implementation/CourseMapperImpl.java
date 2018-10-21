package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseDetailDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseWithoutInstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.domain.Instructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
            courseDTO.setAmountStudent(course.getAmountStudent());
            courseDTO.setRating(course.getRating());
            courseDTO.setImage(course.getImage());
            courseDTO.setInstructors(this.instructorSetToInstructorDTOSet(course.getInstructors()));
            return courseDTO;
        }
    }

    @Override
    public CourseWithoutInstructorDTO courseToCourseWithoutInstructorDto(Course course) {
        if (course == null) {
            return null;
        } else {
            CourseWithoutInstructorDTO courseWithoutInstructorDTO = new CourseWithoutInstructorDTO();
            courseWithoutInstructorDTO.setId(course.getId());
            courseWithoutInstructorDTO.setName(course.getName());
            courseWithoutInstructorDTO.setDescription(course.getDescription());
            courseWithoutInstructorDTO.setCost(course.getCost());
            courseWithoutInstructorDTO.setAmountStudent(course.getAmountStudent());
            courseWithoutInstructorDTO.setRating(course.getRating());
            courseWithoutInstructorDTO.setImage(course.getImage());
            return courseWithoutInstructorDTO;
        }
    }

    @Override
    public CourseDetailDTO courseToCourseDetailDto(Course course) {
        if (course == null) {
            return null;
        } else {
            CourseDetailDTO courseDetailDTO = new CourseDetailDTO();
            courseDetailDTO.setId(course.getId());
            courseDetailDTO.setName(course.getName());
            courseDetailDTO.setDescription(course.getDescription());
            courseDetailDTO.setCost(course.getCost());
            courseDetailDTO.setAmountStudent(course.getAmountStudent());
            courseDetailDTO.setRating(course.getRating());
            courseDetailDTO.setImage(course.getImage());
            courseDetailDTO.setDescriptionDetail(course.getDescriptionDetail());
            courseDetailDTO.setContentSummary(this.setToArrayList(course.getContentSummary()));
            courseDetailDTO.setRequirements(this.setToArrayList(course.getRequirements()));
            courseDetailDTO.setInstructors(this.instructorSetToInstructorDTOSet(course.getInstructors()));
            return courseDetailDTO;
        }
    }

    private ArrayList<String> setToArrayList(Set<String> set){
        if(set==null) return null;
        ArrayList<String> list = new ArrayList<>();
        set.forEach(s -> list.add(s));
        return list;
    }

    private InstructorDTO instructorToInstructorDTO(Instructor instructor){
        if(instructor ==null) return null;
        InstructorDTO instructorDTO = new InstructorDTO();
        instructorDTO.setUsername(instructor.getUsername());
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
