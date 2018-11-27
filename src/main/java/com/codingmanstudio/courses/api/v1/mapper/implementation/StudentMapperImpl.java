package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.Utils.EncrytedPasswordUtils;
import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.RoleDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentCreateDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentWithoutCourseDTO;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.api.v1.mapper.ImageMapper;
import com.codingmanstudio.courses.api.v1.mapper.StudentMapper;
import com.codingmanstudio.courses.domain.Role;
import com.codingmanstudio.courses.domain.Student;
import com.codingmanstudio.courses.domain.StudentCourse;
import com.codingmanstudio.courses.exceptions.WrongDataFormatException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class StudentMapperImpl implements StudentMapper {

    private final CourseMapper courseMapper;
    private final ImageMapper imageMapper;

    public StudentMapperImpl(CourseMapper courseMapper, ImageMapper imageMapper) {
        this.courseMapper = courseMapper;
        this.imageMapper = imageMapper;
    }

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public StudentDTO studentToStudentDto(Student student) {
        if (student == null) return null;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setUsername(student.getUsername());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setName(student.getName());
        if (student.getImage() != null)
            studentDTO.setImage(student.getImage().getUrl());
        if (student.getDob() != null)
            studentDTO.setDob(student.getDob());
        studentDTO.setSchool(student.getSchool());
        studentDTO.setCourses(this.courseSetToCourseDTOSet(student.getCourses()));
        studentDTO.setRoles(this.roleSetToRoleDTOSet(student.getRoles()));
        return studentDTO;
    }

    @Override
    public StudentWithoutCourseDTO studentToStudentWithoutCourseDto(Student student) {
        if (student == null) return null;
        StudentWithoutCourseDTO studentWithoutCourseDTO = new StudentWithoutCourseDTO();
        studentWithoutCourseDTO.setUsername(student.getUsername());
        studentWithoutCourseDTO.setEmail(student.getEmail());
        studentWithoutCourseDTO.setName(student.getName());
        studentWithoutCourseDTO.setDob(student.getDob());
        studentWithoutCourseDTO.setSchool(student.getSchool());
        return studentWithoutCourseDTO;
    }

    @Override
    public Student studentCreateDTOToStudent(StudentCreateDTO studentCreateDTO) {
        if (studentCreateDTO == null)
            return null;
        else {
            Student student = new Student();
            student.setName(studentCreateDTO.getName());
            student.setSchool(studentCreateDTO.getSchool());
            student.setEmail(studentCreateDTO.getEmail());
            try {
                if (student.getDob() != null)
                    student.setDob(format.parse(studentCreateDTO.getDob()));
            } catch (ParseException e) {
                throw new WrongDataFormatException("Wrong date format");
            }
            student.setUsername(studentCreateDTO.getUsername());
            student.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword(studentCreateDTO.getPassword()));
            if (studentCreateDTO.getImage() != null)
                student.setImage(imageMapper.imageDTOToImage(studentCreateDTO.getImage()));
            return student;
        }
    }


    private Set<CourseDTO> courseSetToCourseDTOSet(Set<StudentCourse> courses) {
        Set<CourseDTO> courseDTOS = new HashSet<>();
        courses.forEach(studentCourse -> {
            courseDTOS.add(courseMapper.courseToCourseDto(studentCourse.getCourse()));
        });
        return courseDTOS;
    }

    private RoleDTO roleToRoleDTO(Role role) {
        if (role == null) return null;
        else {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRole(role.getRole());
            return roleDTO;
        }
    }

    private List<String> roleSetToRoleDTOSet(Set<Role> roles) {
        if (roles == null) {
            return null;
        } else {
            List<String> roleList = new ArrayList<>();
            roles.forEach(role -> roleList.add(role.getRole()));
            return roleList;
        }
    }
}
