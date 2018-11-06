package com.codingmanstudio.courses.api.v1.dto.Section;


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
public class SectionDTO implements Comparable<SectionDTO>{

    private String id;
    private int ordinalNumber;
    private String description;
    private String content;

    @Override
    public int compareTo(SectionDTO o) {
        return Integer.compare(this.getOrdinalNumber(),o.getOrdinalNumber());
    }
}
