package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.Section.SectionDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionWithoutContentDTO;

import java.util.TreeSet;

public interface SectionService {
    SectionDTO getSectionDetail(String sectionId);
    TreeSet<SectionWithoutContentDTO> getListSections(String lessonId);
}
