package com.codingmanstudio.courses.domain;

import com.codingmanstudio.courses.repository.CourseRepository;
import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Category {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotNull
    @NotBlank
    private String name;

    @Lob
    private String description;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Course> courses = new HashSet<>();

    public void addCourse(Course course){
        course.setCategory(this);
        this.courses.add(course);
    }
}
