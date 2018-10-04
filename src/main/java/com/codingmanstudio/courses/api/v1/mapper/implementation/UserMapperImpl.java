package com.codingmanstudio.courses.api.v1.mapper.implementation;

import com.codingmanstudio.courses.api.v1.dto.RoleDTO;
import com.codingmanstudio.courses.api.v1.dto.UserDTO;
import com.codingmanstudio.courses.api.v1.mapper.UserMapper;
import com.codingmanstudio.courses.domain.Account;
import com.codingmanstudio.courses.domain.Role;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@NoArgsConstructor
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDTO userToUserDto(Account account) {
        if (account == null)
            return null;
        else {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(account.getUsername());
            userDTO.setRoles(this.roleSetToRoleDTOSet(account.getRoles()));
            return userDTO;
        }
    }

    private RoleDTO roleToRoleDTO(Role role) {
        if (role == null) return null;
        else {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRole(role.getRole());
            return roleDTO;
        }
    }

    private List<String> roleSetToRoleDTOSet(Set<Role> roles) {
        if (roles == null) {
            return null;
        } else {
            List<String> roleList = new ArrayList<>();
            roles.forEach(role -> roleList.add(role.getRole()));
            return roleList;
        }
    }
}
