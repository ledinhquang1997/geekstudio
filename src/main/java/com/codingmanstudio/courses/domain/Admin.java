package com.codingmanstudio.courses.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Admin extends Account{
    @NotBlank
    private String name;

    @Email
    private String email;

}
