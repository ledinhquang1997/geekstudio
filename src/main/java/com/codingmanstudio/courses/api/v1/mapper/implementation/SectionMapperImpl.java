package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.Course.StudentCourseDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionWithoutContentDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.StudentSectionDTO;
import com.codingmanstudio.courses.api.v1.mapper.SectionMapper;
import com.codingmanstudio.courses.domain.Section;
import org.springframework.stereotype.Component;

@Component
public class SectionMapperImpl implements SectionMapper {

    @Override
    public SectionDTO sectionToSectionDto(Section section) {
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

    @Override
    public SectionWithoutContentDTO sectionToSectionWithoutContentDto(Section section) {
        if (section == null) return null;
        else {
            SectionWithoutContentDTO sectionWithoutContentDTO = new SectionWithoutContentDTO();
            sectionWithoutContentDTO.setId(section.getId());
            sectionWithoutContentDTO.setDescription(section.getDescription());
            sectionWithoutContentDTO.setOrdinalNumber(section.getOrdinalNumber());
            sectionWithoutContentDTO.setDateCreate(section.getDateCreated());
            sectionWithoutContentDTO.setLastUpdate(section.getLastUpdate());
            return sectionWithoutContentDTO;
        }
    }
}
