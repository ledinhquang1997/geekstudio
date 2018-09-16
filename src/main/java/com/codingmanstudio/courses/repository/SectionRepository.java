package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Sections;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SectionRepository extends JpaRepository<Sections, UUID> {
}
