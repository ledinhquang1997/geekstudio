package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.Course.*;
import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonWithSectionsDTO;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.api.v1.mapper.LessonMapper;
import com.codingmanstudio.courses.domain.*;
import com.codingmanstudio.courses.exceptions.ResourceNotFoundException;
import com.codingmanstudio.courses.repository.*;
import com.codingmanstudio.courses.services.CourseService;
import org.springframework.data.domain.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final CategoryRepository categoryRepository;
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;
    private final LessonMapper lessonMapper;
    private final LessonRepository lessonRepository;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper, CategoryRepository categoryRepository, StudentRepository studentRepository, StudentCourseRepository studentCourseRepository, LessonMapper lessonMapper, LessonRepository lessonRepository) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.categoryRepository = categoryRepository;
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
        this.lessonMapper = lessonMapper;
        this.lessonRepository = lessonRepository;
    }

    private static final String POPUPLAR = "POPULAR";
    private static final String RATING = "RATING";

    @Override
    public ListCourseDTO getAllCourses() {
        Sort sortable = Sort.by("amountStudent").descending();
        Pageable pageable = PageRequest.of(0, 1000, sortable);

        Page page = courseRepository.findAll(pageable);
        List<CourseDTO> courseDTOs = courseRepository.findAll(pageable)
                .stream()
                .map(courseMapper::courseToCourseDto)
                .collect(Collectors.toList());

        ListCourseDTO listCourseDTO = new ListCourseDTO();
        listCourseDTO.setCourseDTOList(courseDTOs);
        listCourseDTO.setTotalPage(page.getTotalPages());
        return listCourseDTO;
    }

    @Override
    public List<CourseDTO> getBestSellerCourse() {
        return courseRepository.findTop6ByOrderByAmountStudentDesc().stream()
                .map(courseMapper::courseToCourseDto).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourseByCategoryId(String id) {
        return courseRepository.findTop8ByCategoryIdOrderByAmountStudentDesc(id).stream().map(courseMapper::courseToCourseDto).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getTopRatingCourse() {
        return courseRepository.findTop8ByOrderByRatingDesc().stream().map(courseMapper::courseToCourseDto).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCoursesByCategoryFilterPage(String category, String filter, int page) {

        Optional<Category> optionalCategory = categoryRepository.findByNameOrId(category, category);
        if (!optionalCategory.isPresent()) {
            throw new ResourceNotFoundException("Category " + category + " not found");
        }

        Category foundCategory = optionalCategory.get();
        String property="";
        if(filter.equals(RATING)) property ="rating";
        else if(filter.equals(POPUPLAR)) property="amountStudent";
        Pageable pageable = PageRequest.of(page, 8, Sort.Direction.DESC,property);

        return courseRepository.findByCategoryId(foundCategory.getId(),pageable)
                .stream()
                .map(courseMapper::courseToCourseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDetailDTO getCourseById(String id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if(!optionalCourse.isPresent()){
            throw new ResourceNotFoundException("Course "+ id + " not found");
        }
        return courseMapper.courseToCourseDetailDto(optionalCourse.get());
    }

    @Override
    public List<StudentCourseDTO> getCoursesOfStudent(String username) {
        Optional<Student> studentOptional = studentRepository.findByUsername(username);
        if(!studentOptional.isPresent()){
            throw new ResourceNotFoundException("Username "+username+" not found");
        }
        Student student = studentOptional.get();

        for (StudentCourse ac : student.getCourses()
        ) {
            System.out.println(ac.getCourse().getName()+ " "+ac.getLearnerRating());
        }
        return student.getCourses().stream().map(courseMapper::courseToStudentCourseDto).collect(Collectors.toList());
    }

    @Override
    public StudentCourseWithLessonsDTO getStudentCourseWithLessons(String username, String courseId) {
        Optional<StudentCourse> studentCourseOptional = studentCourseRepository.findByStudentUsernameAndCourseId(username,courseId);
        if(!studentCourseOptional.isPresent()){
            throw new ResourceNotFoundException("Course "+courseId+" of student "+username+" not found");
        }
        return courseMapper.courseToStudentCourseWithLessonsDto(studentCourseOptional.get());
    }

    @Override
    public LessonWithSectionsDTO getLessonWithSections(String lessonId) {
        Optional<Lesson> lessonOptional=lessonRepository.findById(lessonId);
        if(!lessonOptional.isPresent()){
            throw new ResourceNotFoundException("Lesson not found");
        }
        Lesson lesson= lessonOptional.get();
        Course course = lesson.getCourse();

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Optional<StudentCourse> studentCourseOptional = studentCourseRepository.findByStudentUsernameAndCourseId(userDetails.getUsername(),course.getId());
        if(!studentCourseOptional.isPresent()){
            throw new ResourceNotFoundException("User "+userDetails.getUsername()+" or course "+course.getId()+ " not found");
        }


        LessonWithSectionsDTO lessonWithSectionsDTO= lessonMapper.lessonToLessonWithSectionsDto(lesson);
        lessonWithSectionsDTO.setSectionProgress(studentCourseOptional.get().getSectionProgress());
        return lessonWithSectionsDTO;
    }
}
