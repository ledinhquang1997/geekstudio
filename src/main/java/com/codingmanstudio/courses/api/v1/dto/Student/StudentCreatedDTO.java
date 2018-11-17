package com.codingmanstudio.courses.api.v1.dto.Student;

import com.codingmanstudio.courses.api.v1.dto.ImageDTO;
import com.codingmanstudio.courses.api.v1.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreatedDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String name;
    private String school;

    private String role;

    @Email
    private String email;
    private Date dob;
    private ImageDTO images;
}
