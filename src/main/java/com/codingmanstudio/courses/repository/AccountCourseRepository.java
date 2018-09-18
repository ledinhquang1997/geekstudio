package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.AccountCourse;
import com.codingmanstudio.courses.domain.AccountCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountCourseRepository extends JpaRepository<AccountCourse, AccountCourseId> {
}
