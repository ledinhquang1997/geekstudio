package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,String> {
}
