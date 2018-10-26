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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @Lob
    private String description;

    @Lob
    private String descriptionDetail;

    private Long cost;

    private int amountStudent;

    @ElementCollection
    private Set<String> contentSummary = new HashSet<>();

    @ElementCollection
    private Set<String> requirements = new HashSet<>();


    @Max(5)
    @Min(1)
    private double rating;

    @Embedded
    private Image image;

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

}
