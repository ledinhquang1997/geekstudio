package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.Course.StudentCourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionWithoutContentDTO;
import com.codingmanstudio.courses.domain.Section;

public interface SectionMapper {
    SectionDTO sectionToSectionDto(Section section);
    SectionWithoutContentDTO sectionToSectionWithoutContentDto(Section section);
}
