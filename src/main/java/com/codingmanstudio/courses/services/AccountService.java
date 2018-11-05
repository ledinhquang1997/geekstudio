package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.Student.StudentDTO;
import com.codingmanstudio.courses.api.v1.dto.UserDTO;

public interface AccountService {
    Object getUserInfo(String username);
    StudentDTO getCurrentStudent(String username);
    StudentDTO addCourse(String username);
    void addprogress(String username);
}
