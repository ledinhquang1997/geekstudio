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
public class SectionWithoutContentDTO implements Comparable<SectionWithoutContentDTO>{
    private String id;
    private int ordinalNumber;
    private String description;

    @Override
    public int compareTo(SectionWithoutContentDTO o) {
        return Integer.compare(this.getOrdinalNumber(),o.getOrdinalNumber());
    }
}
