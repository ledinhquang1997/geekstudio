package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.domain.CustomUserDetail;
import com.codingmanstudio.courses.domain.Student;
import com.codingmanstudio.courses.repository.AccountRepository;
import com.codingmanstudio.courses.domain.Account;
import com.codingmanstudio.courses.domain.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Account> accountCredentials = accountRepository.findById(username);
        if (!accountCredentials.isPresent()) {
            throw new RuntimeException();
        }
        Account account= accountCredentials.get();
        if(account instanceof Student){
            Student student= (Student) account;
            CustomUserDetail customUserDetail = new CustomUserDetail(account.getUsername(),account.getEncrytedPassword(),getAuthorities(account.getRoles()));
            customUserDetail.setEmail(student.getEmail());
            customUserDetail.setSchool(student.getSchool());
            return customUserDetail;
        }
        return new User(account.getUsername(),account.getEncrytedPassword(),getAuthorities(account.getRoles()));
    }

    private List<SimpleGrantedAuthority> getAuthorities(Set<Role> roles) {
        return roles
                .stream()
                .map(role -> {
                    System.out.println(role.getRole());
                    return new SimpleGrantedAuthority(role.getRole());
                })
                .collect(Collectors.toList());
    }
}

