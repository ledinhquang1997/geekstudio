package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section,String> {
}
