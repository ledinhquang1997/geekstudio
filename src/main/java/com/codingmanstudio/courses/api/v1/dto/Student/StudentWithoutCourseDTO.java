package com.codingmanstudio.courses.api.v1.dto.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithoutCourseDTO {
    private String username;
    private String name;
    private String school;
    private String email;
    private Date dob;
}
