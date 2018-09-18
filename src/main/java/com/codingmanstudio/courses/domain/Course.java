package com.codingmanstudio.courses.domain;

import com.codingmanstudio.courses.repository.CategoryRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Course {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String description;

    private Long cost;

    @Max(5)
    @Min(1)
    private Long rating;

    private String image;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private String dateCreate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Lesson> lessons = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "courses")
    private Set<Instructor> instructors = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "courses_topics", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private Set<Topic> topics = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "account")
    private Set<AccountCourse> accounts = new HashSet<>();

    public void addCategory(Category category, CategoryRepository categoryRepository){
        category.getCourses().add(this);
        Category savedCategory = categoryRepository.save(category);
        System.out.println(savedCategory.getName());
        this.category = savedCategory;
    }

}
