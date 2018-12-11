package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionUpdateDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionWithoutContentDTO;
import com.codingmanstudio.courses.domain.Section;
import com.codingmanstudio.courses.services.SectionService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.TreeSet;

@CrossOrigin
@RestController
@RequestMapping("/management/section")
public class SectionManagementController {
    private final SectionService sectionService;

    public SectionManagementController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all/{lessonId}")
    public TreeSet<SectionWithoutContentDTO> getListSection(@PathVariable String lessonId) {
        return sectionService.getListSections(lessonId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{sectionId}")
    public SectionUpdateDTO getSectionUpdate(@PathVariable String sectionId) {
        return sectionService.getSectionUpdate(sectionId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_INSTRUCTOR')")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/")
    public SectionUpdateDTO updateSection(@RequestBody SectionUpdateDTO sectionUpdateDTO) {
        return sectionService.updateSection(sectionUpdateDTO);
    }

}
