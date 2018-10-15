package com.codingmanstudio.courses.api.v1.dto.Course;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseWithoutInstructorDTO implements Comparable<CourseWithoutInstructorDTO>{
    private String id;
    private String name;
    private String description;
    private Long cost;
    private double rating;
    private Integer amountStudent;
    private String image;

    @Override
    public int compareTo(CourseWithoutInstructorDTO o) {
        if(this.amountStudent.compareTo(o.amountStudent)==0) return 1;
        else return o.amountStudent.compareTo(this.amountStudent);
    }
}
