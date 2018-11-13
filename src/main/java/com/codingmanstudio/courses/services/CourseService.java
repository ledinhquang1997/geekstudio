package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.Course.*;
import com.codingmanstudio.courses.api.v1.dto.Course.Update.ProgressDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonWithDetailedSectionsDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.StudentLessonWithSectionsDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionDTO;

import java.util.List;

public interface CourseService {
    ListCourseDTO getAllCourses();
    List<CourseDTO> getBestSellerCourse();
    List<CourseDTO> getCourseByCategoryId(String id);
    List<CourseDTO> getTopRatingCourse();
    List<CourseDTO> getCoursesByCategoryFilterPage(String category, String filter, int page);
    CourseDetailDTO getCourseById(String id);
    List<StudentCourseDTO> getCoursesOfStudent(String username);
    StudentCourseWithLessonsDTO getStudentCourseWithLessons(String username,String courseId);
    StudentLessonWithSectionsDTO getLessonWithSections(String lessonId);
    CourseWithLessonsDTO getCourseWithLessons(String courseId);
    LessonWithDetailedSectionsDTO getLessonWithDetailedSections(String lessonId);
    SectionDTO getSectionDetail(String sectionId);
    StudentCourseDTO changeProgress(ProgressDTO progressDTO);
}
