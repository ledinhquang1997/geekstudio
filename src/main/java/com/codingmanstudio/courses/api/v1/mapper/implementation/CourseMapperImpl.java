package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseDetailDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseWithoutInstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.StudentCourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.api.v1.mapper.InstructorMapper;
import com.codingmanstudio.courses.domain.Category;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.domain.Instructor;
import com.codingmanstudio.courses.domain.StudentCourse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CourseMapperImpl implements CourseMapper {
    private final InstructorMapper instructorMapper;

    public CourseMapperImpl(InstructorMapper instructorMapper) {
        this.instructorMapper = instructorMapper;
    }

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
            courseDTO.setImage(course.getImage().getUrl());
            courseDTO.setCategory(this.categoryToCategoryDto(course.getCategory()));
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
            courseWithoutInstructorDTO.setImage(course.getImage().getUrl());
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
            courseDetailDTO.setImage(course.getImage().getUrl());
            courseDetailDTO.setDescriptionDetail(course.getDescriptionDetail());
            courseDetailDTO.setContentSummary(this.setToArrayList(course.getContentSummary()));
            courseDetailDTO.setRequirements(this.setToArrayList(course.getRequirements()));
            courseDetailDTO.setInstructors(this.instructorSetToInstructorDTOSet(course.getInstructors()));
            return courseDetailDTO;
        }
    }

    @Override
    public StudentCourseDTO courseToStudentCourseDto(StudentCourse studentCourse) {
        if (studentCourse == null) {
            return null;
        } else {
            StudentCourseDTO studentCourseDTO = new StudentCourseDTO();
            studentCourseDTO.setId(studentCourse.getCourse().getId());
            studentCourseDTO.setName(studentCourse.getCourse().getName());
            studentCourseDTO.setDescription(studentCourse.getCourse().getDescription());
            studentCourseDTO.setCost(studentCourse.getCourse().getCost());
            studentCourseDTO.setAmountStudent(studentCourse.getCourse().getAmountStudent());
            studentCourseDTO.setRating(studentCourse.getCourse().getRating());
            studentCourseDTO.setImage(studentCourse.getCourse().getImage().getUrl());
            studentCourseDTO.setCategory(this.categoryToCategoryDto(studentCourse.getCourse().getCategory()));
            studentCourseDTO.setInstructors(this.instructorSetToInstructorDTOSet(studentCourse.getCourse().getInstructors()));
            studentCourseDTO.setLessonProgress(studentCourse.getLessonProgress());
            studentCourseDTO.setSectionProgress(studentCourse.getSectionProgress());
            studentCourseDTO.setLearnerRating(studentCourse.getLearnerRating());
            return studentCourseDTO;
        }
    }

    private CategoryDTO categoryToCategoryDto(Category category) {
        if (category == null) {
            return null;
        } else {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());
            categoryDTO.setDescription(category.getDescription());
            categoryDTO.setImage(category.getImage().getUrl());
            return categoryDTO;
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
        instructorDTO.setImage(instructor.getImage().getUrl());
        instructorDTO.setQuote(instructor.getQuote());
        return  instructorDTO;
    }

    private Set<InstructorDTO> instructorSetToInstructorDTOSet(Set<Instructor> instructors){
        if(instructors==null) return null;
        return instructors.stream()
                .map(instructorMapper::instructorToInstructorDto)
                .collect(Collectors.toSet());
    }
}
