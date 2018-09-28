package com.codingmanstudio.courses.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstructorDTO {
    private String id;
    private String name;
    private String company;
    private String email;
    private String image;
    private String quote;
    private Set<CategoryDTO> categories = new HashSet<>();
}
