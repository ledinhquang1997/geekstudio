package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.Student.StudentCreateDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentWithoutCourseDTO;
import com.codingmanstudio.courses.api.v1.mapper.StudentMapper;
import com.codingmanstudio.courses.domain.Account;
import com.codingmanstudio.courses.domain.Role;
import com.codingmanstudio.courses.domain.Student;
import com.codingmanstudio.courses.exceptions.ResourceAlreadyExistException;
import com.codingmanstudio.courses.exceptions.ResourceNotFoundException;
import com.codingmanstudio.courses.repository.AccountRepository;
import com.codingmanstudio.courses.repository.RoleRepository;
import com.codingmanstudio.courses.repository.StudentRepository;
import com.codingmanstudio.courses.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper, RoleRepository roleRepository, AccountRepository accountRepository) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.roleRepository = roleRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<StudentWithoutCourseDTO> getListStudents() {
        return studentRepository.findAll().stream().map(studentMapper::studentToStudentWithoutCourseDto).collect(Collectors.toList());
    }

    @Override
    public StudentDTO createStudent(StudentCreateDTO studentCreateDTO) {
        Optional<Account> accountOptional = accountRepository.findByUsername(studentCreateDTO.getUsername());
        if(accountOptional.isPresent()){
            throw new ResourceAlreadyExistException("Username "+ studentCreateDTO.getUsername()+ " already exist");
        }
        Student student= studentMapper.studentCreateDTOToStudent(studentCreateDTO);
        Optional<Role> optionalRole = roleRepository.findByRole("ROLE_LEARNER");
        if (!optionalRole.isPresent()) {
            throw new ResourceNotFoundException("Role not found");
        }

        student.getRoles().add(optionalRole.get());
        Student savedStudent = studentRepository.save(student);
        return studentMapper.studentToStudentDto(savedStudent);
    }
}
