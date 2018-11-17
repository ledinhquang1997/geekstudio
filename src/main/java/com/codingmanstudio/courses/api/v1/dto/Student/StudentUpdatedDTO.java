package com.codingmanstudio.courses.api.v1.dto.Student;

import com.codingmanstudio.courses.api.v1.dto.ImageDTO;
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
public class StudentUpdatedDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
    private String role;

    @NotBlank
    private String name;

    private String school;

    @Email
    private String email;
    private Date dob;
    private ImageDTO images;
}
