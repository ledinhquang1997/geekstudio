package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonWithSectionsDTO;
import com.codingmanstudio.courses.domain.Lesson;

public interface LessonMapper {
    LessonWithSectionsDTO lessonToLessonWithSectionsDto(Lesson lesson);
}
