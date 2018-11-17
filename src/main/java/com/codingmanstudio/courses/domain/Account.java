package com.codingmanstudio.courses.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @NotBlank
    private String username;

    private String encrytedPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "accounts_roles", joinColumns = @JoinColumn(name = "account_username"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles=new HashSet<>();

    public Account() {
    }

    public Account(String username, String encrytedPassword) {
        this.username = username;
        this.encrytedPassword = encrytedPassword;
    }


}
