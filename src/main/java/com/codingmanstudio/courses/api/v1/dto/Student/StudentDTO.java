package com.codingmanstudio.courses.api.v1.dto.Student;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String username;
    private List<String> roles;
    private String name;
    private String school;
    private String email;
    private String image;
    private Date dob;
    private Set<CourseDTO> courses = new HashSet<>();
}
