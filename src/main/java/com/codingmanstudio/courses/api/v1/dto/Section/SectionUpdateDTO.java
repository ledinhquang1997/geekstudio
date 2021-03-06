package com.codingmanstudio.courses.api.v1.dto.Section;

import com.codingmanstudio.courses.api.v1.dto.VideoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SectionUpdateDTO {
    private String id;
    private int ordinalNumber;
    private String description;
    private String content;
    private VideoDTO video;
}
