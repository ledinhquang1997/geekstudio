package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonWithDetailedSectionsDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.StudentLessonWithSectionsDTO;
import com.codingmanstudio.courses.domain.Lesson;

public interface LessonMapper {
    StudentLessonWithSectionsDTO lessonToLessonWithSectionsDto(Lesson lesson);
    LessonWithDetailedSectionsDTO lessonToLessonWithDetailedSectionsDto(Lesson lesson);
}
