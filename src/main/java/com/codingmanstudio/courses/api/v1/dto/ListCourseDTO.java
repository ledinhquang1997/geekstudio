package com.codingmanstudio.courses.api.v1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCourseDTO {
    @JsonProperty("courses")
    List<CourseDTO> courseDTOList;
    int totalPage;
}
