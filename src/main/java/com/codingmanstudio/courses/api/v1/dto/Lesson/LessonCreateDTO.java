package com.codingmanstudio.courses.api.v1.dto.Lesson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonCreateDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    @NotNull
    private String courseId;
}
