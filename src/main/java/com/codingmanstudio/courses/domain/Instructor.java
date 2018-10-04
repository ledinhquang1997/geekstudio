package com.codingmanstudio.courses.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Instructor extends Account{

    @NotBlank
    private String name;

    private String company;

    @Email
    private String email;

    private String image;

    private String quote;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "instructors_courses", joinColumns = @JoinColumn(name = "instructor_username"),inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "instructors_categories", joinColumns = @JoinColumn(name = "instructor_username"),inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

}
