package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.ImageDTO;
import com.codingmanstudio.courses.api.v1.mapper.ImageMapper;
import com.codingmanstudio.courses.domain.Image;
import org.springframework.stereotype.Component;

@Component
public class ImageMapperImpl implements ImageMapper {
    @Override
    public Image imageDTOToImage(ImageDTO imageDTO) {
        if (imageDTO==null)return null;
        else {
            Image image = new Image();
            image.setUrl(imageDTO.getUrl());
            image.setDeleteToken(imageDTO.getDeleteToken());
            return image;
        }
    }
}