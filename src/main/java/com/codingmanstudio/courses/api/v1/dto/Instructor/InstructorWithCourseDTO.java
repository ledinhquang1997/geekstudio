package com.codingmanstudio.courses.api.v1.dto.Instructor;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;
import com.codingmanstudio.courses.domain.Course;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstructorWithCourseDTO {
    @NotBlank
    private String name;

    private String company;

    @Email
    private String email;

    private String image;

    private String quote;

    private Set<CourseDTO> courses = new HashSet<>();
}
