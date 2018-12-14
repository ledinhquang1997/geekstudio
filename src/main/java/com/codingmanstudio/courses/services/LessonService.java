package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonCreateDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonUpdateDTO;

import java.util.TreeSet;

public interface LessonService {
    TreeSet<LessonDTO> getListLesson(String courseId);
    LessonDTO getLesson(String lessonId);
    LessonDTO updateLesson(LessonUpdateDTO lessonUpdateDTO);
    LessonDTO createLesson(LessonCreateDTO lessonCreateDTO);
    void deleteLesson(String lessonId);
}
