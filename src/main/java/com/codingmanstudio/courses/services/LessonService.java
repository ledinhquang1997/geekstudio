package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonDTO;

import java.util.TreeSet;

public interface LessonService {
    TreeSet<LessonDTO> getListLesson(String courseId);
    LessonDTO getLesson(String lessonId);
}
