package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,String> {
}
