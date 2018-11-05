package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseDetailDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseWithoutInstructorDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.StudentCourseDTO;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.domain.StudentCourse;

public interface CourseMapper {

    CourseDTO courseToCourseDto(Course course);
    CourseWithoutInstructorDTO courseToCourseWithoutInstructorDto(Course course);
    CourseDetailDTO courseToCourseDetailDto(Course course);
    StudentCourseDTO courseToStudentCourseDto(StudentCourse studentCourse);
}
