package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.Section.SectionDTO;
import com.codingmanstudio.courses.api.v1.dto.Section.SectionWithoutContentDTO;
import com.codingmanstudio.courses.api.v1.mapper.SectionMapper;
import com.codingmanstudio.courses.domain.*;
import com.codingmanstudio.courses.exceptions.NoAuthenticationException;
import com.codingmanstudio.courses.exceptions.ResourceNotFoundException;
import com.codingmanstudio.courses.repository.*;
import com.codingmanstudio.courses.services.SectionService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements SectionService {
    private final SectionRepository sectionRepository;
    private final LessonRepository lessonRepository;
    private final StudentRepository studentRepository;
    private final SectionMapper sectionMapper;
    private final StudentCourseRepository studentCourseRepository;
    private final InstructorRepository instructorRepository;

    public SectionServiceImpl(SectionRepository sectionRepository, LessonRepository lessonRepository, StudentRepository studentRepository, SectionMapper sectionMapper, StudentCourseRepository studentCourseRepository, InstructorRepository instructorRepository) {
        this.sectionRepository = sectionRepository;
        this.lessonRepository = lessonRepository;
        this.studentRepository = studentRepository;
        this.sectionMapper = sectionMapper;
        this.studentCourseRepository = studentCourseRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public SectionDTO getSectionDetail(String sectionId) {
        Optional<Section> sectionOptional = sectionRepository.findById(sectionId);
        if (!sectionOptional.isPresent()) {
            throw new ResourceNotFoundException("Section not found");
        }

        Section section = sectionOptional.get();

        Optional<Lesson> lessonOptional = lessonRepository.findById(section.getLesson().getId());
        if (!lessonOptional.isPresent()) {
            throw new ResourceNotFoundException("Lesson not found");
        }
        Lesson lesson = lessonOptional.get();

        Course course = lesson.getCourse();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Optional<StudentCourse> studentCourseOptional = studentCourseRepository.findByStudentUsernameAndCourseId(userDetails.getUsername(), course.getId());
        if (!studentCourseOptional.isPresent()) {
            throw new ResourceNotFoundException("User " + userDetails.getUsername() + " or course " + course.getId() + " not found");
        }

        return sectionMapper.sectionToSectionDto(section);

    }

    @Override
    public TreeSet<SectionWithoutContentDTO> getListSections(String lessonId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        if (!lessonOptional.isPresent()) {
            throw new ResourceNotFoundException("Lesson " + lessonId + " not found");
        }

        Course course = lessonOptional.get().getCourse();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (!userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_INSTRUCTOR"))) {
                Optional<Instructor> optionalInstructor = instructorRepository.findByUsername(userDetails.getUsername());
                if (!optionalInstructor.isPresent()) {
                    throw new NoAuthenticationException("Username " + userDetails.getUsername() + " is not an instructor");
                }
                Instructor instructor = optionalInstructor.get();
                if (!instructor.getCourses().contains(course)) {
                    throw new NoAuthenticationException("Instructor " + userDetails.getUsername() + " does not own course " + course.getId());
                }
            }
        return lessonOptional.get().getSections().stream().map(sectionMapper::sectionToSectionWithoutContentDto).collect(Collectors.toCollection(TreeSet::new));
    }
}