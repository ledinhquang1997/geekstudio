package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.Course.*;
import com.codingmanstudio.courses.api.v1.dto.Course.Create.CourseCreateDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.Update.CourseUpdateDTO;
import com.codingmanstudio.courses.api.v1.dto.Course.Update.ProgressDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.LessonWithDetailedSectionsDTO;
import com.codingmanstudio.courses.api.v1.dto.Lesson.StudentLessonWithSectionsDTO;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.api.v1.mapper.ImageMapper;
import com.codingmanstudio.courses.api.v1.mapper.LessonMapper;
import com.codingmanstudio.courses.api.v1.mapper.SectionMapper;
import com.codingmanstudio.courses.domain.*;
import com.codingmanstudio.courses.exceptions.NoAuthenticationException;
import com.codingmanstudio.courses.exceptions.ResourceNotFoundException;
import com.codingmanstudio.courses.repository.*;
import com.codingmanstudio.courses.services.CourseService;
import org.springframework.data.domain.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;
    private final InstructorRepository instructorRepository;
    private final ImageMapper imageMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper, CategoryRepository categoryRepository, StudentRepository studentRepository, StudentCourseRepository studentCourseRepository, LessonMapper lessonMapper, LessonRepository lessonRepository, SectionRepository sectionRepository, SectionMapper sectionMapper, InstructorRepository instructorRepository, ImageMapper imageMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.categoryRepository = categoryRepository;
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
        this.lessonMapper = lessonMapper;
        this.lessonRepository = lessonRepository;
        this.sectionRepository = sectionRepository;
        this.sectionMapper = sectionMapper;
        this.instructorRepository = instructorRepository;
        this.imageMapper = imageMapper;
    }

    private static final String POPUPLAR = "POPULAR";
    private static final String RATING = "RATING";

    @Override
    public ListCourseDTO getAllCourses() {
        Sort sortable = Sort.by("amountStudent").descending();
        Pageable pageable = PageRequest.of(0, 1000, sortable);

        Page page = courseRepository.findAll(pageable);
        List<CourseDTO> courseDTOs = courseRepository.findAll(pageable)
                .stream().filter(course -> !course.getDeleted())
                .map(courseMapper::courseToCourseDto)
                .collect(Collectors.toList());

        ListCourseDTO listCourseDTO = new ListCourseDTO();
        listCourseDTO.setCourseDTOList(courseDTOs);
        listCourseDTO.setTotalPage(page.getTotalPages());
        return listCourseDTO;
    }

    @Override
    public List<CourseDTO> getBestSellerCourse() {
        return courseRepository.findTop6ByDeletedIsFalseOrderByAmountStudentDesc().stream()
                .map(courseMapper::courseToCourseDto).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourseByCategoryId(String id) {
        return courseRepository.findTop8ByCategoryIdOrderByAmountStudentDesc(id).stream().filter(course -> !course.getDeleted()).map(courseMapper::courseToCourseDto).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getTopRatingCourse() {
        return courseRepository.findTop8ByDeletedIsFalseOrderByRatingDesc().stream().filter(course -> !course.getDeleted()).map(courseMapper::courseToCourseDto).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCoursesByCategoryFilterPage(String category, String filter, int page) {

        Optional<Category> optionalCategory = categoryRepository.findByNameOrId(category, category);
        if (!optionalCategory.isPresent()) {
            throw new ResourceNotFoundException("Category " + category + " not found");
        }

        Category foundCategory = optionalCategory.get();
        String property = "";
        if (filter.equals(RATING)) property = "rating";
        else if (filter.equals(POPUPLAR)) property = "amountStudent";
        Pageable pageable = PageRequest.of(page, 8, Sort.Direction.DESC, property);

        return courseRepository.findByCategoryId(foundCategory.getId(), pageable)
                .stream().filter(course -> !course.getDeleted())
                .map(courseMapper::courseToCourseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDetailDTO getCourseById(String id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (!optionalCourse.isPresent()) {
            throw new ResourceNotFoundException("Course " + id + " not found");
        }
        return courseMapper.courseToCourseDetailDto(optionalCourse.get());
    }

    @Override
    public List<StudentCourseDTO> getCoursesOfStudent(String username) {
        Optional<Student> studentOptional = studentRepository.findByUsername(username);
        if (!studentOptional.isPresent()) {
            throw new ResourceNotFoundException("Username " + username + " not found");
        }
        Student student = studentOptional.get();

        for (StudentCourse ac : student.getCourses()
        ) {
            System.out.println(ac.getCourse().getName() + " " + ac.getLearnerRating());
        }
        return student.getCourses().stream().filter(course -> !course.getCourse().getDeleted()).map(courseMapper::courseToStudentCourseDto).collect(Collectors.toList());
    }

    @Override
    public StudentCourseWithLessonsDTO getStudentCourseWithLessons(String username, String courseId) {
        Optional<StudentCourse> studentCourseOptional = studentCourseRepository.findByStudentUsernameAndCourseId(username, courseId);
        if (!studentCourseOptional.isPresent()) {
            throw new ResourceNotFoundException("Course " + courseId + " of student " + username + " not found");
        }


        StudentCourseWithLessonsDTO studentCourseWithLessonsDTO = courseMapper.courseToStudentCourseWithLessonsDto(studentCourseOptional.get());
        studentCourseWithLessonsDTO.setCurrentSection(studentCourseOptional.get().getCurrentSection().getId());
        studentCourseWithLessonsDTO.setCurrentLesson(studentCourseOptional.get().getCurrentSection().getLesson().getId());
        return studentCourseWithLessonsDTO;
    }

    @Override
    public StudentLessonWithSectionsDTO getLessonWithSections(String lessonId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
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


        StudentLessonWithSectionsDTO studentLessonWithSectionsDTO = lessonMapper.lessonToLessonWithSectionsDto(lesson);
        studentLessonWithSectionsDTO.setSectionProgress(studentCourseOptional.get().getSectionProgress());
        studentLessonWithSectionsDTO.setCurrentSection(studentCourseOptional.get().getCurrentSection().getId());
        studentLessonWithSectionsDTO.setCurrentLesson(studentCourseOptional.get().getCurrentLesson().getId());
        return studentLessonWithSectionsDTO;
    }

    @Override
    public CourseWithLessonsDTO getCourseWithLessons(String courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (!courseOptional.isPresent()) {
            throw new ResourceNotFoundException("Course not found");
        }

        return courseMapper.courseToCourseWithLessonsDto(courseOptional.get());
    }

    @Override
    public LessonWithDetailedSectionsDTO getLessonWithDetailedSections(String lessonId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        if (!lessonOptional.isPresent()) {
            throw new ResourceNotFoundException("Lesson not found");
        }
        Lesson lesson = lessonOptional.get();

        return lessonMapper.lessonToLessonWithDetailedSectionsDto(lesson);

    }


    @Override
    public StudentCourseDTO changeProgress(ProgressDTO progressDTO) {
        if (progressDTO == null) {
            throw new ResourceNotFoundException("Data not found");
        } else {
            if (progressDTO.getSectionId() == null) {
                if (progressDTO.getLessonId() != null) {

                    Optional<Lesson> lessonOptional = lessonRepository.findById(progressDTO.getLessonId());
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

                    StudentCourse studentCourse = studentCourseOptional.get();
                    studentCourse.setCurrentLesson(lesson);
                    studentCourse.setCurrentSection(lesson.getSections().stream().filter(section -> section.getOrdinalNumber() == 1).findAny().orElse(null));
                    StudentCourse savedStudentCourse = studentCourseRepository.save(studentCourse);

                    System.out.println(savedStudentCourse.getCurrentSection().getId() + "   " + savedStudentCourse.getCurrentLesson().getId());

                    return courseMapper.courseToStudentCourseDto(savedStudentCourse);
                } else {
                    throw new ResourceNotFoundException("Data not found");
                }
            }

            Optional<Section> sectionOptional = sectionRepository.findById(progressDTO.getSectionId());
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

            StudentCourse studentCourse = studentCourseOptional.get();
            studentCourse.setCurrentLesson(lesson);
            studentCourse.setCurrentSection(section);
            StudentCourse savedStudentCourse = studentCourseRepository.save(studentCourse);
            System.out.println(savedStudentCourse.getCurrentSection().getId() + "   " + savedStudentCourse.getCurrentLesson().getId());
            return courseMapper.courseToStudentCourseDto(savedStudentCourse);
        }
    }

    @Override
    public List<CourseWithoutInstructorDTO> getListCourseManagement() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return courseRepository.findAll().stream().filter(course -> !course.getDeleted()).map(courseMapper::courseToCourseWithoutInstructorDto).collect(Collectors.toList());
        } else {
            Optional<Instructor> instructorOptional = instructorRepository.findByUsername(userDetails.getUsername());
            if (!instructorOptional.isPresent()) {
                throw new ResourceNotFoundException("Instructor " + userDetails.getUsername() + " not found");
            }
            return instructorOptional.get().getCourses().stream().filter(course -> !course.getDeleted()).map(courseMapper::courseToCourseWithoutInstructorDto).collect(Collectors.toList());
        }
    }

    @Override
    public CourseDetailDTO createCourse(CourseCreateDTO courseCreateDTO) {

        Course course = courseMapper.courseCreateDTOToCourse(courseCreateDTO);
        Optional<Category> categoryOptional = categoryRepository.findById(courseCreateDTO.getCategoryId());
        if (categoryOptional.isPresent()) {
            course.setCategory(categoryOptional.get());
        }

        Course savedCourse = courseRepository.save(course);


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_INSTRUCTOR"))) {
            Optional<Instructor> optionalInstructor = instructorRepository.findByUsername(userDetails.getUsername());
            if (optionalInstructor.isPresent()) {
                Instructor instructor = optionalInstructor.get();
                instructor.getCourses().add(savedCourse);
                instructorRepository.save(instructor);
            }
        }

        return courseMapper.courseToCourseDetailDto(savedCourse);
    }

    @Override
    public CourseDetailDTO updateCourse(CourseUpdateDTO courseUpdateDTO) {
        if (courseUpdateDTO == null) return null;
        Optional<Course> courseOptional = courseRepository.findById(courseUpdateDTO.getId());
        if (!courseOptional.isPresent()) {
            throw new ResourceNotFoundException("Course " + courseUpdateDTO.getId() + " not found");
        }
        Course foundCourse = courseOptional.get();
        checkAuthenticate(foundCourse);

        foundCourse.setName(courseUpdateDTO.getName());
        foundCourse.setDescription(courseUpdateDTO.getDescription());
        foundCourse.setDescriptionDetail(courseUpdateDTO.getDescriptionDetail());
        foundCourse.setCost(courseUpdateDTO.getCost());
        foundCourse.setContentSummary(courseUpdateDTO.getContentSummary());
        foundCourse.setRequirements(courseUpdateDTO.getRequirements());
        foundCourse.setImage(imageMapper.imageDTOToImage(courseUpdateDTO.getImage()));

        Optional<Category> categoryOptional = categoryRepository.findById(courseUpdateDTO.getCategoryId());
        if (categoryOptional.isPresent()) {
            foundCourse.setCategory(categoryOptional.get());
        }

        Course savedCourse = courseRepository.save(foundCourse);
        return courseMapper.courseToCourseDetailDto(savedCourse);
    }

    @Override
    public List<CourseDTO> search(String name) {
        return courseRepository.findByNameIsContaining(name).stream().filter(course -> !course.getDeleted()).map(courseMapper::courseToCourseDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCourse(String courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if(!courseOptional.isPresent()){
            throw new ResourceNotFoundException("Course "+courseId+" not found");
        }

        Course course = courseOptional.get();
        checkAuthenticate(course);

        course.setDeleted(true);
        courseRepository.save(course);
    }

    void checkAuthenticate(Course course) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) return;

        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_INSTRUCTOR"))) {
            Optional<Instructor> optionalInstructor = instructorRepository.findByUsername(userDetails.getUsername());
            if (!optionalInstructor.isPresent()) {
                throw new ResourceNotFoundException("Instructor " + userDetails.getUsername() + " not found");
            }
            Instructor instructor = optionalInstructor.get();
            if (!instructor.getCourses().contains(course)) {
                throw new ResourceNotFoundException("Instructor " + userDetails.getUsername() + " is not the owner of course " + course.getId());
            }
        } else if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_STUDENT"))) {
            Optional<StudentCourse> studentCourseOptional = studentCourseRepository.findByStudentUsernameAndCourseId(userDetails.getUsername(), course.getId());
            if (!studentCourseOptional.isPresent()) {
                throw new ResourceNotFoundException("Student " + userDetails.getUsername() + " is not the owner of course " + course.getId());
            }
        } else throw new NoAuthenticationException("No role found");

    }

}
