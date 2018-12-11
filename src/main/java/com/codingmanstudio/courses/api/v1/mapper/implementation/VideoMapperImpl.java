package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.VideoDTO;
import com.codingmanstudio.courses.api.v1.mapper.VideoMapper;
import com.codingmanstudio.courses.domain.Image;
import com.codingmanstudio.courses.domain.Video;
import org.springframework.stereotype.Component;

@Component
public class VideoMapperImpl implements VideoMapper {
    @Override
    public VideoDTO videoToVideoDto(Video video) {
        if(video==null) return null;
        else {
            VideoDTO videoDTO = new VideoDTO();
            videoDTO.setUrl(video.getUrl());
            videoDTO.setDeleteToken(video.getDeleteToken());
            return videoDTO;
        }
    }

    @Override
    public Video videoDtoToVideo(VideoDTO videoDTO) {
        if (videoDTO == null) return null;
        Video video = new Video();
        video.setUrl(videoDTO.getUrl());
        video.setDeleteToken(videoDTO.getDeleteToken());
        return video;
    }
}
