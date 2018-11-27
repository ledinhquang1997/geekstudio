package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.ImageDTO;
import com.codingmanstudio.courses.domain.Image;

public interface ImageMapper {
    Image imageDTOToImage(ImageDTO imageDTO);
}