package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.VideoDTO;
import com.codingmanstudio.courses.domain.Video;

public interface VideoMapper {
    VideoDTO videoToVideoDto(Video video);
    Video videoDtoToVideo(VideoDTO videoDTO);
}
