package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.api.v1.dto.UserDTO;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.api.v1.mapper.StudentMapper;
import com.codingmanstudio.courses.api.v1.mapper.UserMapper;
import com.codingmanstudio.courses.domain.*;
import com.codingmanstudio.courses.exceptions.ResourceNotFoundException;
import com.codingmanstudio.courses.repository.AccountRepository;
import com.codingmanstudio.courses.repository.CourseRepository;
import com.codingmanstudio.courses.repository.StudentCourseRepository;
import com.codingmanstudio.courses.repository.StudentRepository;
import com.codingmanstudio.courses.services.AccountService;
import com.codingmanstudio.courses.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {

    private final StudentRepository studentRepository;
    private final AccountRepository accountRepository;
    private final UserMapper userMapper;
    private final StudentMapper studentMapper;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final StudentCourseRepository studentCourseRepository;

    public AccountServiceImpl(StudentRepository studentRepository, AccountRepository accountRepository, UserMapper userMapper, StudentMapper studentMapper, CourseRepository courseRepository, CourseMapper courseMapper, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.accountRepository = accountRepository;
        this.userMapper = userMapper;
        this.studentMapper = studentMapper;
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public Object getUserInfo(String username) {
        Optional<Account> accountOptional = accountRepository.findByUsername(username);
        if (accountOptional.isPresent()) {
            if(accountOptional.get() instanceof  Student){
                return getCurrentStudent(username);
            }
            if (accountOptional.get() instanceof Admin) {
                System.out.println("Yessssssssssss");
                Admin admin = (Admin) accountOptional.get();
                System.out.println(admin.getName());
                System.out.println(admin.getEmail());
            }
            return userMapper.userToUserDto(accountOptional.get());

        } else {
            return null;
        }
    }

    @Override
    public StudentDTO getCurrentStudent(String username) {


        Optional<Student> studentOptional = studentRepository.findByUsername(username);
        if (!studentOptional.isPresent()) {
            throw new ResourceNotFoundException("Student "+username+" not found");
        }

        Set<StudentCourse> studentCourseList = studentOptional.get().getCourses();

        for (StudentCourse ac : studentCourseList
        ) {
            System.out.println(ac.getCourse().getName()+ " "+ac.getLearnerRating());
        }

        StudentDTO studentDTO = studentMapper.studentToStudentDto(studentOptional.get());
        return studentDTO;
    }

    @Override
    public StudentDTO addCourse(String username) {
        Optional<Course> courseOptional = courseRepository.findByName("TypeScript course");
        if(!courseOptional.isPresent()){
            throw new ResourceNotFoundException("Course not found");
        }

        Course typeScript= courseOptional.get();

        Optional<Student> studentOptional = studentRepository.findByUsername(username);
        if (!studentOptional.isPresent()) {
            throw new ResourceNotFoundException("Student "+username+" not found");
        }

        Student student = studentOptional.get();
        student.addCourse(typeScript);
        Student savedStudent = studentRepository.save(student);

        StudentDTO studentDTO = studentMapper.studentToStudentDto(savedStudent);
        return studentDTO;
    }

    @Override
    public void addprogress(String username) {
        Optional<Student> studentOptional = studentRepository.findByUsername(username);
        if (!studentOptional.isPresent()) {
            throw new ResourceNotFoundException("Student "+username+" not found");
        }


        StudentCourse studentCourse = studentCourseRepository.findByStudentUsernameAndCourseName(username,"Docker - magic tool");
        studentCourse.setLearnerRating(4.4);


        studentCourseRepository.save(studentCourse);
    }


}
