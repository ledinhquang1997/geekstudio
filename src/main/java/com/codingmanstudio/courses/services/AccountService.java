package com.codingmanstudio.courses.services;

import com.codingmanstudio.courses.api.v1.dto.UserDTO;

public interface AccountService {
    public UserDTO getUserInfo(String username);
}
