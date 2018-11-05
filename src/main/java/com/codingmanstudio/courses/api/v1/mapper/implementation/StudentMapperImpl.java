package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.Course.CourseDTO;
import com.codingmanstudio.courses.api.v1.dto.RoleDTO;
import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.api.v1.mapper.CourseMapper;
import com.codingmanstudio.courses.api.v1.mapper.StudentMapper;
import com.codingmanstudio.courses.domain.Course;
import com.codingmanstudio.courses.domain.Role;
import com.codingmanstudio.courses.domain.Student;
import com.codingmanstudio.courses.domain.StudentCourse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StudentMapperImpl implements StudentMapper {

    private final CourseMapper courseMapper;

    public StudentMapperImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public StudentDTO studentToStudentDto(Student student) {
        if(student==null) return null;
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setUsername(student.getUsername());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setName(student.getName());
        studentDTO.setImage(student.getImage().getUrl());
        studentDTO.setDob(student.getDob());
        studentDTO.setSchool(student.getSchool());
        studentDTO.setCourses(this.courseSetToCourseDTOSet(student.getCourses()));
        studentDTO.setRoles(this.roleSetToRoleDTOSet(student.getRoles()));
        return studentDTO;
    }

    private Set<CourseDTO> courseSetToCourseDTOSet(Set<StudentCourse> courses){
        Set<CourseDTO> courseDTOS = new HashSet<>();
        courses.forEach(studentCourse ->{
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
