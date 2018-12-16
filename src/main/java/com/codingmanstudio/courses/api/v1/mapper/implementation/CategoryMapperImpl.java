package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryStatisticDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryWithCoursesDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryWithTopicsDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseWithoutInstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.TopicDTO;
import com.codingmanstudio.courses.api.v1.mapper.CategoryMapper;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.api.v1.mapper.InstructorMapper;
import com.codingmanstudio.courses.api.v1.mapper.TopicMapper;
import com.codingmanstudio.courses.domain.Category;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.domain.Instructor;
import com.codingmanstudio.courses.domain.Topic;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    private final CourseMapper courseMapper;
    private final TopicMapper topicMapper;
    private final InstructorMapper instructorMapper;

    public CategoryMapperImpl(CourseMapper courseMapper, TopicMapper topicMapper, InstructorMapper instructorMapper) {
        this.courseMapper = courseMapper;
        this.topicMapper = topicMapper;
        this.instructorMapper = instructorMapper;
    }


    @Override
    public CategoryDTO categoryToCategoryDto(Category category) {
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

    @Override
    public CategoryWithCoursesDTO categoryToCategoryWithCoursesDto(Category category) {
        if (category == null) {
            return null;
        } else {
            CategoryWithCoursesDTO categoryWithCoursesDTO = new CategoryWithCoursesDTO();
            categoryWithCoursesDTO.setId(category.getId());
            categoryWithCoursesDTO.setName(category.getName());
            categoryWithCoursesDTO.setDescription(category.getDescription());
            categoryWithCoursesDTO.setImage(category.getImage().getUrl());
            categoryWithCoursesDTO.setCourses(this.courseSetToCourseWithCoursesDTOSet(category.getCourses()));
            return categoryWithCoursesDTO;
        }
    }

    @Override
    public CategoryWithTopicsDTO categoryToCategoryWithTopicsDto(Category category) {
        if (category == null) {
            return null;
        } else {
            CategoryWithTopicsDTO categoryWithTopicsDTO = new CategoryWithTopicsDTO();
            categoryWithTopicsDTO.setId(category.getId());
            categoryWithTopicsDTO.setName(category.getName());
            categoryWithTopicsDTO.setDescription(category.getDescription());
            categoryWithTopicsDTO.setImage(category.getImage().getUrl());
            categoryWithTopicsDTO.setTopics(this.topicSetTopicDTOSet(category.getTopics()));
            categoryWithTopicsDTO.setInstructors(this.instructorSetToInstructorDTOSet(category.getInstructors()));
            return categoryWithTopicsDTO;
        }
    }

    @Override
    public CategoryStatisticDTO categoryToCategoryStatisticDto(Category category) {
        if (category == null) return null;
        else {
            int quantityStudent = 0;
            for (Course course : category.getCourses()
            ) {
                quantityStudent+=course.getAmountStudent();
            }
            CategoryStatisticDTO categoryStatisticDTO = new CategoryStatisticDTO();
            categoryStatisticDTO.setCategory(category.getName());
            categoryStatisticDTO.setY(quantityStudent);
            return categoryStatisticDTO;
        }
    }

    private Set<TopicDTO> topicSetTopicDTOSet(Set<Topic> topics) {
        return topics.stream().map(topicMapper::topicTopicDto).collect(Collectors.toSet());
    }

    private Set<InstructorDTO> instructorSetToInstructorDTOSet(Set<Instructor> instructors) {
        return instructors.stream().map(instructorMapper::instructorToInstructorDto).collect(Collectors.toSet());
    }

    private TreeSet<CourseWithoutInstructorDTO> courseSetToCourseWithCoursesDTOSet(Set<Course> courses) {
        return courses.stream().filter(course -> !course.getDeleted()).map(courseMapper::courseToCourseWithoutInstructorDto).collect(Collectors.toCollection(TreeSet::new));
    }
}

