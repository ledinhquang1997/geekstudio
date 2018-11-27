package com.codingmanstudio.courses.api.v1.dto.Lesson;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LessonDTO implements Comparable<LessonDTO>{

    private String id;
    private int ordinalNumber;
    private String name;
    private String description;
    private Date dateCreate;
    private Date lastUpdate;

    @Override
    public int compareTo(LessonDTO o) {
        return Integer.compare(this.getOrdinalNumber(),o.getOrdinalNumber());
    }
}
