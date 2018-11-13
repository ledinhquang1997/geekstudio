package com.codingmanstudio.courses.api.v1.dto.Course;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseWithLessonsDTO {

    private String id;
    private String name;
    private String description;
    private Long cost;
    private double rating;
    private int amountStudent;
    private String image;
    private CategoryDTO category;
    private Set<InstructorDTO> instructors = new HashSet<>();

    private TreeSet<LessonDTO> lessons= new TreeSet<>();
}
