package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryWithCoursesDTO;
import com.codingmanstudio.courses.api.v1.dto.Category.CategoryWithTopicsDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseWithoutInstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.TopicDTO;
import com.codingmanstudio.courses.api.v1.mapper.CategoryMapper;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.api.v1.mapper.TopicMapper;
import com.codingmanstudio.courses.domain.Category;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.domain.Topic;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    private final CourseMapper courseMapper;
    private final TopicMapper topicMapper;
    public CategoryMapperImpl(CourseMapper courseMapper, TopicMapper topicMapper) {
        this.courseMapper = courseMapper;
        this.topicMapper = topicMapper;
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
            categoryDTO.setImage(category.getImage());
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
            categoryWithCoursesDTO.setImage(category.getImage());
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
            categoryWithTopicsDTO.setImage(category.getImage());
            categoryWithTopicsDTO.setTopics(this.topicSetTopicDTOSet(category.getTopics()));
            return categoryWithTopicsDTO;
        }
    }

    private Set<TopicDTO> topicSetTopicDTOSet(Set<Topic> topics){
        return topics.stream().map(topicMapper::topicTopicDto).collect(Collectors.toSet());
    }

    private TreeSet<CourseWithoutInstructorDTO> courseSetToCourseWithCoursesDTOSet(Set<Course> courses){
        return courses.stream().map(courseMapper::courseToCourseWithoutInstructorDto).collect(Collectors.toCollection(TreeSet::new));
    }
}

