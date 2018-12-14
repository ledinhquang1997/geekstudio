package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.*;
import com.codingmanstudio.courses.api.v1.dto.Course.Create.CourseCreateDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonDTO;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.api.v1.mapper.ImageMapper;
import com.codingmanstudio.courses.api.v1.mapper.InstructorMapper;
import com.codingmanstudio.courses.domain.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class CourseMapperImpl implements CourseMapper {
    private final InstructorMapper instructorMapper;
    private final ImageMapper imageMapper;
    public CourseMapperImpl(InstructorMapper instructorMapper, ImageMapper imageMapper) {
        this.instructorMapper = instructorMapper;
        this.imageMapper = imageMapper;
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
            courseDetailDTO.setCategory(this.categoryToCategoryDto(course.getCategory()));
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
            studentCourseDTO.setTotalLesson(studentCourse.getCourse().getLessons().size());
            int totalSection = 0;
            int totalLesson = 0;
            for (Lesson lesson : studentCourse.getCourse().getLessons()
            ) {
                totalSection += lesson.getSections().size();
                totalLesson++;
            }
            studentCourseDTO.setTotalLesson(totalLesson);
            studentCourseDTO.setTotalSection(totalSection);
            return studentCourseDTO;
        }
    }

    @Override
    public StudentCourseWithLessonsDTO courseToStudentCourseWithLessonsDto(StudentCourse studentCourse) {
        if (studentCourse == null) {
            return null;
        } else {
            StudentCourseWithLessonsDTO studentCourseWithLessonsDTO = new StudentCourseWithLessonsDTO();
            studentCourseWithLessonsDTO.setId(studentCourse.getCourse().getId());
            studentCourseWithLessonsDTO.setName(studentCourse.getCourse().getName());
            studentCourseWithLessonsDTO.setDescription(studentCourse.getCourse().getDescription());
            studentCourseWithLessonsDTO.setCost(studentCourse.getCourse().getCost());
            studentCourseWithLessonsDTO.setAmountStudent(studentCourse.getCourse().getAmountStudent());
            studentCourseWithLessonsDTO.setRating(studentCourse.getCourse().getRating());
            studentCourseWithLessonsDTO.setImage(studentCourse.getCourse().getImage().getUrl());
            studentCourseWithLessonsDTO.setCategory(this.categoryToCategoryDto(studentCourse.getCourse().getCategory()));
            studentCourseWithLessonsDTO.setInstructors(this.instructorSetToInstructorDTOSet(studentCourse.getCourse().getInstructors()));
            studentCourseWithLessonsDTO.setLessonProgress(studentCourse.getLessonProgress());
            studentCourseWithLessonsDTO.setSectionProgress(studentCourse.getSectionProgress());
            studentCourseWithLessonsDTO.setLearnerRating(studentCourse.getLearnerRating());
            studentCourseWithLessonsDTO.setTotalLesson(studentCourse.getCourse().getLessons().size());
            int totalSection = 0;
            int totalLesson = 0;
            for (Lesson lesson : studentCourse.getCourse().getLessons()
            ) {
                totalSection += lesson.getSections().size();
                totalLesson++;
            }
            studentCourseWithLessonsDTO.setTotalLesson(totalLesson);
            studentCourseWithLessonsDTO.setTotalSection(totalSection);
            studentCourseWithLessonsDTO.setLessons(this.lessonSetToLessonDTOSet(studentCourse.getCourse().getLessons()));

            return studentCourseWithLessonsDTO;
        }
    }

    @Override
    public CourseWithLessonsDTO courseToCourseWithLessonsDto(Course course) {
        if (course == null) return null;
        else {
            CourseWithLessonsDTO courseWithLessonsDTO = new CourseWithLessonsDTO();
            courseWithLessonsDTO.setId(course.getId());
            courseWithLessonsDTO.setName(course.getName());
            courseWithLessonsDTO.setDescription(course.getDescription());
            courseWithLessonsDTO.setCost(course.getCost());
            courseWithLessonsDTO.setAmountStudent(course.getAmountStudent());
            courseWithLessonsDTO.setRating(course.getRating());
            courseWithLessonsDTO.setImage(course.getImage().getUrl());
            courseWithLessonsDTO.setCategory(this.categoryToCategoryDto(course.getCategory()));
            courseWithLessonsDTO.setInstructors(this.instructorSetToInstructorDTOSet(course.getInstructors()));
            courseWithLessonsDTO.setLessons(this.lessonSetToLessonDTOSet(course.getLessons()));
            return courseWithLessonsDTO;
        }
    }

    @Override
    public Course courseCreateDTOToCourse(CourseCreateDTO courseCreateDTO) {
        if(courseCreateDTO==null) return null;
        else {
            Course course = new Course();
            course.setName(courseCreateDTO.getName());
            course.setDescription(courseCreateDTO.getDescription());
            course.setDescriptionDetail(courseCreateDTO.getDescriptionDetail());
            course.setCost(courseCreateDTO.getCost());
            course.setContentSummary(courseCreateDTO.getContentSummary());
            course.setRequirements(courseCreateDTO.getRequirements());
            course.setImage(imageMapper.imageDTOToImage(courseCreateDTO.getImage()));
            course.setDateCreate(courseCreateDTO.getDateCreate());
            return course;
        }
    }

    private LessonDTO lessonToLessonDTO(Lesson lesson) {
        if (lesson == null) return null;
        else {
            LessonDTO lessonDTO = new LessonDTO();
            lessonDTO.setId(lesson.getId());
            lessonDTO.setName(lesson.getName());
            lessonDTO.setDescription(lesson.getDescription());
            lessonDTO.setOrdinalNumber(lesson.getOrdinalNumber());
            return lessonDTO;
        }
    }

    private TreeSet<LessonDTO> lessonSetToLessonDTOSet(Set<Lesson> lessons) {
        return lessons.stream().filter(lesson -> !lesson.getDeleted()).map(this::lessonToLessonDTO).collect(Collectors.toCollection(TreeSet::new));
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

    private ArrayList<String> setToArrayList(Set<String> set) {
        if (set == null) return null;
        ArrayList<String> list = new ArrayList<>();
        set.forEach(s -> list.add(s));
        return list;
    }

    private InstructorDTO instructorToInstructorDTO(Instructor instructor) {
        if (instructor == null) return null;
        InstructorDTO instructorDTO = new InstructorDTO();
        instructorDTO.setUsername(instructor.getUsername());
        instructorDTO.setCompany(instructor.getCompany());
        instructorDTO.setEmail(instructor.getEmail());
        instructorDTO.setName(instructor.getName());
        instructorDTO.setImage(instructor.getImage().getUrl());
        instructorDTO.setQuote(instructor.getQuote());
        return instructorDTO;
    }

    private Set<InstructorDTO> instructorSetToInstructorDTOSet(Set<Instructor> instructors) {
        if (instructors == null) return null;
        return instructors.stream()
                .map(instructorMapper::instructorToInstructorDto)
                .collect(Collectors.toSet());
    }
}
