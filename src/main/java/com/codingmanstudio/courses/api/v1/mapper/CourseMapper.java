package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.Course.*;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.domain.StudentCourse;

public interface CourseMapper {

    CourseDTO courseToCourseDto(Course course);
    CourseWithoutInstructorDTO courseToCourseWithoutInstructorDto(Course course);
    CourseDetailDTO courseToCourseDetailDto(Course course);
    StudentCourseDTO courseToStudentCourseDto(StudentCourse studentCourse);
    StudentCourseWithLessonsDTO courseToStudentCourseWithLessonsDto(StudentCourse studentCourse);
}
