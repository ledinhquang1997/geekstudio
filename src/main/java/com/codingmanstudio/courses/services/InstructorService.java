package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.InstructorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InstructorService {
    public List<InstructorDTO> getAllInstructors();
}
