package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorWithCourseDTO;
import com.codingmanstudio.courses.api.v1.mapper.InstructorMapper;
import com.codingmanstudio.courses.domain.Category;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.domain.Instructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InstructorMapperImpl implements InstructorMapper {
    @Override
    public InstructorDTO instructorToInstructorDto(Instructor instructor) {
        if (instructor == null) {
            return null;
        } else {
            InstructorDTO instructorDTO = new InstructorDTO();
            instructorDTO.setUsername(instructor.getUsername());
            instructorDTO.setName(instructor.getName());
            instructorDTO.setCompany(instructor.getCompany());
            instructorDTO.setEmail(instructor.getEmail());
            instructorDTO.setImage(instructor.getImage().getUrl());
            instructorDTO.setQuote(instructor.getQuote());
            instructorDTO.setCategories(this.categorySetToCategoryDTOSet(instructor.getCategories()));
            return instructorDTO;
        }
    }

    @Override
    public InstructorWithCourseDTO instructorToInstructorWithCourseDTO(Instructor instructor) {
        if (instructor == null) {
            return null;
        } else {
            InstructorWithCourseDTO instructorWithCourseDTO = new InstructorWithCourseDTO();
            instructorWithCourseDTO.setName(instructor.getName());
            instructorWithCourseDTO.setCompany(instructor.getCompany());
            instructorWithCourseDTO.setEmail(instructor.getEmail());
            instructorWithCourseDTO.setQuote(instructor.getQuote());
            instructorWithCourseDTO.setImage(instructor.getImage().getUrl());
            instructorWithCourseDTO.setCourses(this.courseSetToCourseDTOSet(instructor.getCourses()));
            return instructorWithCourseDTO;
        }
    }

    private CategoryDTO categoryToCategoryDTO(Category category) {
        if (category == null) {
            return null;
        } else {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());
            categoryDTO.setDescription(category.getDescription());
            return categoryDTO;
        }
    }

    private CourseDTO courseToCourseDTO(Course course){
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
            courseDTO.setImage(course.getImage().getUrl());
            return courseDTO;
        }
    }

    private Set<CategoryDTO> categorySetToCategoryDTOSet(Set<Category> categories) {
        return categories.stream().map(this::categoryToCategoryDTO).collect(Collectors.toSet());
    }

    private Set<CourseDTO> courseSetToCourseDTOSet(Set<Course> courses){
        return courses.stream().map(this::courseToCourseDTO).collect(Collectors.toSet());
    }
}
