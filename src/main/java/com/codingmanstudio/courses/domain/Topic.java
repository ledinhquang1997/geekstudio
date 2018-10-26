package com.codingmanstudio.courses.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Topic {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotBlank
    private String name;

    private String image;

    @ManyToMany(mappedBy = "topics")
    private Set<Course> courses = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "categories_topics", joinColumns = @JoinColumn(name = "category_id"),inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private Set<Category> categories = new HashSet<>();
}
