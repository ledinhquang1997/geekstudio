package com.codingmanstudio.courses.api.v1.dto.Course.Update;

import com.codingmanstudio.courses.api.v1.dto.Category.CategoryDTO;
import com.codingmanstudio.courses.api.v1.dto.ImageDTO;
import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseUpdateDTO {
    @NotNull
    private String id;
    @NotBlank
    private String name;
    private String description;
    private String descriptionDetail;
    private Long cost;
    private String categoryId;
    private Set<String> contentSummary = new HashSet<>();
    private Set<String> requirements = new HashSet<>();
    private ImageDTO image;
}
