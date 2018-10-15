package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.TopicDTO;
import com.codingmanstudio.courses.domain.Topic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicMapper {
    TopicDTO topicTopicDto(Topic topic);
}
