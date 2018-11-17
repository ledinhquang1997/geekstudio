package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.Utils.EncrytedPasswordUtils;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentCreatedDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentUpdatedDTO;
import com.codingmanstudio.courses.api.v1.mapper.ImageMapper;
import com.codingmanstudio.courses.api.v1.mapper.StudentMapper;
import com.codingmanstudio.courses.domain.Role;
import com.codingmanstudio.courses.domain.Student;
import com.codingmanstudio.courses.exceptions.NoAuthenticationException;
import com.codingmanstudio.courses.exceptions.ResourceNotFoundException;
import com.codingmanstudio.courses.repository.RoleRepository;
import com.codingmanstudio.courses.repository.StudentRepository;
import com.codingmanstudio.courses.services.StudentService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final ImageMapper imageMapper;
    private final RoleRepository roleRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper, ImageMapper imageMapper, RoleRepository roleRepository) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.imageMapper = imageMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public StudentDTO addStudent(StudentCreatedDTO studentCreatedDTO) {

        Optional<Student> optionalStudent = studentRepository.findByUsername(studentCreatedDTO.getUsername());
        if (!optionalStudent.isPresent()) {
            Student student = new Student();
            student.setUsername(studentCreatedDTO.getUsername());
            student.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword(studentCreatedDTO.getPassword()));
            student.setName(studentCreatedDTO.getName());
            student.setSchool(studentCreatedDTO.getSchool());
            student.setDob(studentCreatedDTO.getDob());
            student.setEmail(studentCreatedDTO.getEmail());
            student.setImage(imageMapper.imageDTOToImage(studentCreatedDTO.getImages()));

            String role = studentCreatedDTO.getRole();

            Optional<Role> optionalRole = roleRepository.findByRole(role);
            if (!optionalRole.isPresent()) {
                throw new ResourceNotFoundException("Role not found");
            }
            student.getRoles().add(optionalRole.get());

            Student savedStudent = studentRepository.save(student);
            return studentMapper.studentToStudentDto(savedStudent);
        } else {
            throw new ResourceNotFoundException("Student " + studentCreatedDTO.getUsername() + " is existed");
        }
    }

    @Override
    public StudentDTO updateStudent(StudentUpdatedDTO studentUpdatedDTO) {

        Optional<Student> optionalStudent = studentRepository.findByUsername(studentUpdatedDTO.getUsername());
        if (!optionalStudent.isPresent()) {
            throw new ResourceNotFoundException("Student not found");
        }
        Student foundStudent = optionalStudent.get();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println(userDetails);

        if (!userDetails.getAuthorities().contains("ROLE_ADMIN")) {
            if (userDetails.getUsername() != studentUpdatedDTO.getUsername()) {
                throw new NoAuthenticationException("Must be admin or your account");
            }
            throw new NoAuthenticationException("Must be admin or your account");
        }

        if (studentUpdatedDTO.getUsername() != null) {
            foundStudent.setUsername(studentUpdatedDTO.getUsername());
        }

        if (studentUpdatedDTO.getPassword() != null) {
            foundStudent.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword(studentUpdatedDTO.getPassword()));
        }

        if (studentUpdatedDTO.getName() != null) {
            foundStudent.setName(studentUpdatedDTO.getName());
        }

        if (studentUpdatedDTO.getDob() != null) {
            foundStudent.setDob(studentUpdatedDTO.getDob());
        }

        if (studentUpdatedDTO.getRole() != null) {
            String role = studentUpdatedDTO.getRole();

            Optional<Role> optionalRole = roleRepository.findByRole(role);
            if (!optionalRole.isPresent()) {
                throw new ResourceNotFoundException("Role not found");
            }
            foundStudent.getRoles().add(optionalRole.get());
        }

        if (studentUpdatedDTO.getEmail() != null) {
            foundStudent.setEmail(studentUpdatedDTO.getEmail());
        }

        if (studentUpdatedDTO.getSchool() != null) {
            foundStudent.setSchool(studentUpdatedDTO.getSchool());
        }

        if (studentUpdatedDTO.getImages() != null) {
            foundStudent.setImage(imageMapper.imageDTOToImage(studentUpdatedDTO.getImages()));
        }

        Student savedStudent = studentRepository.save(foundStudent);
        return studentMapper.studentToStudentDto(savedStudent);
    }
}
