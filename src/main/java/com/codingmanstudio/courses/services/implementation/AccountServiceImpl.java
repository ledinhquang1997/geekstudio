package com.codingmanstudio.courses.services.implementation;

import com.codingmanstudio.courses.api.v1.dto.UserDTO;
import com.codingmanstudio.courses.api.v1.mapper.UserMapper;
import com.codingmanstudio.courses.domain.Account;
import com.codingmanstudio.courses.domain.Admin;
import com.codingmanstudio.courses.repository.AccountRepository;
import com.codingmanstudio.courses.services.AccountService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserMapper userMapper;

    public AccountServiceImpl(AccountRepository accountRepository, UserMapper userMapper) {
        this.accountRepository = accountRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getUserInfo(String username) {
        Optional<Account> accountOptional = accountRepository.findByUsername(username);
        if(accountOptional.isPresent()){
            if(accountOptional.get() instanceof Admin)
            {
                System.out.println("Yessssssssssss");
                Admin admin = (Admin) accountOptional.get();
                System.out.println(admin.getName());
                System.out.println(admin.getEmail());
            }
            return userMapper.userToUserDto(accountOptional.get());

        }
        else
        {
            return null;
        }
    }
}
