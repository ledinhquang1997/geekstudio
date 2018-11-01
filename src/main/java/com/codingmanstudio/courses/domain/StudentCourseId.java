package com.codingmanstudio.courses.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseId implements Serializable {
    @Column(name = "student_username")
    private String username;

    @Column(name ="course_id")
    private String courseId;
}
