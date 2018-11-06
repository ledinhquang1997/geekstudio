package com.codingmanstudio.courses.api.v1.dto.Course;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentCourseWithLessonsDTO {

    private String id;
    private String name;
    private String description;
    private Long cost;
    private double rating;
    private int amountStudent;
    private String image;
    private CategoryDTO category;
    private Set<InstructorDTO> instructors = new HashSet<>();

    private int totalLesson;
    private int totalSection;
    private int lessonProgress;
    private int sectionProgress;
    private Double learnerRating;

    private TreeSet<LessonDTO> lessons= new TreeSet<>();
}
