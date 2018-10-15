package com.codingmanstudio.courses.api.v1.dto.Course;

import com.codingmanstudio.courses.api.v1.dto.Instructor.InstructorDTO;
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
public class CourseDTO implements Comparable<CourseDTO>{
    private String id;
    private String name;
    private String description;
    private Long cost;
    private double rating;
    private int amountStudent;
    private String image;
    private Set<InstructorDTO> instructors = new HashSet<>();

    @Override
    public int compareTo(CourseDTO o) {
        return Integer.compare(o.amountStudent,this.amountStudent);
    }
}
