package com.codingmanstudio.courses.api.v1.dto.Course;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDetailDTO {
    private String id;
    private String name;
    private String description;
    private String descriptionDetail;
    private Long cost;
    private CategoryDTO category;
    private double rating;
    private int amountStudent;
    private ArrayList<String> contentSummary;
    private ArrayList<String> requirements;
    private String image;
    private Set<InstructorDTO> instructors = new HashSet<>();
}
