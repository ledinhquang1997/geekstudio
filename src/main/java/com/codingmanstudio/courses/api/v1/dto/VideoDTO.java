package com.codingmanstudio.courses.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VideoDTO {

    private String url;
    @Lob
    private String deleteToken;
}
