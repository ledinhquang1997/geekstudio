package com.codingmanstudio.courses.api.v1.dto.Lesson;

import com.codingmanstudio.courses.api.v1.dto.Section.SectionDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionWithoutContentDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.TreeSet;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonWithDetailedSectionsDTO {
    private String id;
    private int ordinalNumber;
    private String name;
    private String description;
    private String courseId;
    private String courseName;
    private int sectionProgress;
    private TreeSet<SectionDTO> sections = new TreeSet<>();
}
