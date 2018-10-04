package com.codingmanstudio.courses.controller;

import com.codingmanstudio.courses.api.v1.dto.UserDTO;
import com.codingmanstudio.courses.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/user")
@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping({"/{username}"})
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserinfo(@PathVariable String username){
        return accountService.getUserInfo(username);
    }
}
