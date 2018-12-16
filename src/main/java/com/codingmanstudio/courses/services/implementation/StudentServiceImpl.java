package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseIdListDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentCreateDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentWithoutCourseDTO;
import com.codingmanstudio.courses.api.v1.mapper.StudentMapper;
import com.codingmanstudio.courses.domain.*;
import com.codingmanstudio.courses.exceptions.NoAuthenticationException;
import com.codingmanstudio.courses.exceptions.RelatedResourceException;
import com.codingmanstudio.courses.exceptions.ResourceAlreadyExistException;
import com.codingmanstudio.courses.exceptions.ResourceNotFoundException;
import com.codingmanstudio.courses.repository.*;
import com.codingmanstudio.courses.services.StudentService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;
    private final CourseRepository courseRepository;
    private final StudentCourseRepository studentCourseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper, RoleRepository roleRepository, AccountRepository accountRepository, CourseRepository courseRepository, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
        this.courseRepository = courseRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public List<StudentWithoutCourseDTO> getListStudents() {
        return studentRepository.findAll().stream().map(studentMapper::studentToStudentWithoutCourseDto).collect(Collectors.toList());
    }

    @Override
    public StudentDTO createStudent(StudentCreateDTO studentCreateDTO) {
        Optional<Account> accountOptional = accountRepository.findByUsername(studentCreateDTO.getUsername());
        if (accountOptional.isPresent()) {
            throw new ResourceAlreadyExistException("Username " + studentCreateDTO.getUsername() + " already exist");
        }
        Student student = studentMapper.studentCreateDTOToStudent(studentCreateDTO);
        Optional<Role> optionalRole = roleRepository.findByRole("ROLE_LEARNER");
        if (!optionalRole.isPresent()) {
            throw new ResourceNotFoundException("Role not found");
        }

        student.getRoles().add(optionalRole.get());
        Student savedStudent = studentRepository.save(student);
        return studentMapper.studentToStudentDto(savedStudent);
    }

    @Transactional
    @Override
    public StudentDTO addCourse(String courseId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (!userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_LEARNER"))) {
            throw new NoAuthenticationException("Account " + userDetails.getUsername() + " is not a student");
        }

        Optional<Student> studentOptional = studentRepository.findByUsername(userDetails.getUsername());
        if (!studentOptional.isPresent()) {
            throw new NoAuthenticationException("Student " + userDetails.getUsername() + " not exist");
        }

        Student student = studentOptional.get();

        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        if (!optionalCourse.isPresent()) {
            throw new ResourceNotFoundException("Course " + courseId + " not found");
        }

        Course foundCourse = optionalCourse.get();

        Optional<StudentCourse> studentCourseOptional = studentCourseRepository.findByStudentUsernameAndCourseId(student.getUsername(), foundCourse.getId());

        if (studentCourseOptional.isPresent()) {
            throw new RelatedResourceException("Student " + userDetails.getUsername() + " already has course " + courseId);
        }

        StudentCourse studentCourse = new StudentCourse(student, foundCourse);

        if (foundCourse.getLessons().size() == 0) {
            throw new ResourceNotFoundException("No lesson found in course " + foundCourse.getName());
        }

        Lesson lesson = foundCourse.getLessons().stream().filter(l -> l.getOrdinalNumber() == 1).findFirst().orElse(null);

        if (lesson == null) {
            throw new ResourceNotFoundException("No first lesson found in course " + foundCourse.getName());
        }

        Section section = lesson.getSections().stream().filter(sec -> sec.getOrdinalNumber() == 1).findFirst().orElse(null);

        if (section == null) {
            throw new ResourceNotFoundException("No first lesson found in course " + foundCourse.getName());
        }


        studentCourse.setCurrentLesson(lesson);
        studentCourse.setCurrentSection(section);
        student.getCourses().add(studentCourse);
        Student savedStudent = studentRepository.save(student);

        foundCourse.setAmountStudent(foundCourse.getAmountStudent()+1);
        courseRepository.save(foundCourse);

        return studentMapper.studentToStudentDto(savedStudent);
    }
}
