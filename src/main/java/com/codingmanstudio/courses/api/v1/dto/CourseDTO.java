package com.codingmanstudio.courses.api.v1.dto;

import com.codingmanstudio.courses.domain.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseDTO {
    private String id;
    private String name;
    private String description;
    private Long cost;
    private Long rating;
    private String image;
//    private Set<Instructor> instructors = new HashSet<>();
}
