package com.codingmanstudio.courses.api.v1.dto.Course.Create;

import com.codingmanstudio.courses.api.v1.dto.ImageDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseCreateDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private String descriptionDetail;
    @NotNull
    private Long cost;

    private Set<String> contentSummary = new HashSet<>();

    private Set<String> requirements = new HashSet<>();

    @NotNull
    private ImageDTO image;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private String dateCreate;

    private String categoryId;
}
