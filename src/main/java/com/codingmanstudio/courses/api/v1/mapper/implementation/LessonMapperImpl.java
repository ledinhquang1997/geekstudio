package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonWithDetailedSectionsDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.StudentLessonWithSectionsDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionWithoutContentDTO;
import com.codingmanstudio.courses.api.v1.mapper.LessonMapper;
import com.codingmanstudio.courses.domain.Lesson;
import com.codingmanstudio.courses.domain.Section;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Component
public class LessonMapperImpl implements LessonMapper {
    @Override
    public StudentLessonWithSectionsDTO lessonToLessonWithSectionsDto(Lesson lesson) {
        if (lesson == null) return null;
        else {
            StudentLessonWithSectionsDTO studentLessonWithSectionsDTO = new StudentLessonWithSectionsDTO();
            studentLessonWithSectionsDTO.setId(lesson.getId());
            studentLessonWithSectionsDTO.setName(lesson.getName());
            studentLessonWithSectionsDTO.setDescription(lesson.getDescription());
            studentLessonWithSectionsDTO.setOrdinalNumber(lesson.getOrdinalNumber());
            studentLessonWithSectionsDTO.setSections(this.sectionSetToSectionWithoutContentDTOTreeSet(lesson.getSections()));
            studentLessonWithSectionsDTO.setCourseId(lesson.getCourse().getId());
            studentLessonWithSectionsDTO.setCourseName(lesson.getCourse().getName());
            return studentLessonWithSectionsDTO;
        }
    }

    @Override
    public LessonWithDetailedSectionsDTO lessonToLessonWithDetailedSectionsDto(Lesson lesson) {
        if (lesson == null) return null;
        else {
            LessonWithDetailedSectionsDTO lessonWithSectionsDTO = new LessonWithDetailedSectionsDTO();
            lessonWithSectionsDTO.setId(lesson.getId());
            lessonWithSectionsDTO.setName(lesson.getName());
            lessonWithSectionsDTO.setDescription(lesson.getDescription());
            lessonWithSectionsDTO.setOrdinalNumber(lesson.getOrdinalNumber());
            lessonWithSectionsDTO.setSections(this.sectionSetToSectionDTOTreeSet(lesson.getSections()));
            lessonWithSectionsDTO.setCourseId(lesson.getCourse().getId());
            lessonWithSectionsDTO.setCourseName(lesson.getCourse().getName());
            return lessonWithSectionsDTO;
        }
    }

    private SectionDTO sectionToSectionDTO(Section section) {
        if (section == null) return null;
        else {
            SectionDTO sectionDTO = new SectionDTO();
            sectionDTO.setId(section.getId());
            sectionDTO.setDescription(section.getDescription());
            sectionDTO.setContent(section.getContent());
            sectionDTO.setOrdinalNumber(section.getOrdinalNumber());
            return sectionDTO;
        }
    }

    private TreeSet<SectionDTO> sectionSetToSectionDTOTreeSet(Set<Section> sectionSet) {
        if (sectionSet == null) return null;
        else {
            return sectionSet.stream().map(this::sectionToSectionDTO).collect(Collectors.toCollection(TreeSet::new));
        }
    }

    private TreeSet<SectionWithoutContentDTO> sectionSetToSectionWithoutContentDTOTreeSet(Set<Section> sectionSet) {
        if (sectionSet == null) return null;
        else {
            return sectionSet.stream().map(this::sectionToSectionWithoutContentDTO).collect(Collectors.toCollection(TreeSet::new));
        }
    }

    private SectionWithoutContentDTO sectionToSectionWithoutContentDTO(Section section) {
        if (section == null) return null;
        else {
            SectionWithoutContentDTO sectionWithoutContentDTO = new SectionWithoutContentDTO();
            sectionWithoutContentDTO.setId(section.getId());
            sectionWithoutContentDTO.setDescription(section.getDescription());
            sectionWithoutContentDTO.setOrdinalNumber(section.getOrdinalNumber());
            return sectionWithoutContentDTO;
        }
    }
}
