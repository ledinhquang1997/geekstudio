package com.codingmanstudio.courses.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentCourse {
    public StudentCourse(Student student,Course course){
        this.student=student;
        this.course=course;
        this.studentCourseId=new StudentCourseId(student.getUsername(),course.getId());
    }

    @EmbeddedId
    private StudentCourseId studentCourseId;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name="student_username")
    private Student student;


    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name="course_id")
    private Course course;

    @Column
    private int lessonProgress;
    @Column
    private int sectionProgress;
    @Column
    private Double learnerRating;
}
