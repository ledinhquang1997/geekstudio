package com.codingmanstudio.courses.api.v1.mapper;

import com.codingmanstudio.courses.api.v1.dto.UserDTO;
import com.codingmanstudio.courses.domain.Account;

public interface UserMapper {
    UserDTO userToUserDto(Account account);
}
