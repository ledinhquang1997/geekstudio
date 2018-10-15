package com.codingmanstudio.courses.api.v1.dto.Category;

import com.codingmanstudio.courses.api.v1.dto.TopicDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryWithTopicsDTO {
    private String id;
    private String name;
    private String description;
    private String image;
    private int totalPage;
    private Set<TopicDTO> topics;
}
