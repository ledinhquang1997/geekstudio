package com.codingmanstudio.courses.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Setter
@Getter
@Entity
public class Section {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private int ordinalNumber;
    
    private String description;

    private Date dateCreated = new Date();

    private Date lastUpdate = new Date();

    @Lob
    private String content;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Lesson lesson;
}
