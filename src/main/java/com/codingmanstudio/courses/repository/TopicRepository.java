package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Lessons;
import com.codingmanstudio.courses.domain.Topics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topics, UUID> {
}
