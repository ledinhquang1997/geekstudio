package com.codingmanstudio.courses.repository;

import com.codingmanstudio.courses.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
}
