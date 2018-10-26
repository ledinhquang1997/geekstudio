package com.codingmanstudio.courses.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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

    private String image;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Course> courses = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "categories")
    private Set<Instructor> instructors = new HashSet<>();

    @ManyToMany()
    private Set<Topic> topics = new HashSet<>();

    public void addCourse(Course course){
        course.setCategory(this);
        this.courses.add(course);
    }
}
