package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonDTO;
import com.codingmanstudio.courses.api.v1.mapper.LessonMapper;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.domain.Instructor;
import com.codingmanstudio.courses.domain.Lesson;
import com.codingmanstudio.courses.exceptions.NoAuthenticationException;
import com.codingmanstudio.courses.exceptions.ResourceNotFoundException;
import com.codingmanstudio.courses.repository.CourseRepository;
import com.codingmanstudio.courses.repository.InstructorRepository;
import com.codingmanstudio.courses.repository.LessonRepository;
import com.codingmanstudio.courses.services.LessonService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final LessonMapper lessonMapper;
    private final LessonRepository lessonRepository;

    public LessonServiceImpl(CourseRepository courseRepository, InstructorRepository instructorRepository, LessonMapper lessonMapper, LessonRepository lessonRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
        this.lessonMapper = lessonMapper;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public TreeSet<LessonDTO> getListLesson(String courseId) {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);
        if (!optionalCourse.isPresent()) {
            throw new ResourceNotFoundException("Course " + courseId + " not found");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (!userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
            if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_INSTRUCTOR"))) {
                Optional<Instructor> optionalInstructor = instructorRepository.findByUsername(userDetails.getUsername());
                if (!optionalInstructor.isPresent()) {
                    throw new NoAuthenticationException("Username " + userDetails.getUsername() + " is not an instructor");
                }
                Instructor instructor = optionalInstructor.get();
                if (!instructor.getCourses().contains(optionalCourse.get())) {
                    throw new NoAuthenticationException("Instructor " + userDetails.getUsername() + " does not own course " + courseId);
                }
            }


        return optionalCourse.get().getLessons().stream().map(lessonMapper::lessonToLessonDTO).collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public LessonDTO getLesson(String lessonId) {

        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        if (!lessonOptional.isPresent()) {
            throw new ResourceNotFoundException("Lessin " + lessonId + " not found");
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
        return lessonMapper.lessonToLessonDTO(lessonOptional.get());
    }
}
