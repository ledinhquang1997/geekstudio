package com.codingmanstudio.courses.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
public class Student extends Account{
    @NotBlank
    private String name;

    private String school;

    @Email
    private String email;

    @Embedded
    private Image image;

    private Date dob;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL ,mappedBy = "student")
    private Set<StudentCourse> courses = new HashSet<>();

    public void addCourse(Course course){
        StudentCourse studentCourse = new StudentCourse(this,course);
        courses.add(studentCourse);
        course.getStudents().add(studentCourse);
    }
}
