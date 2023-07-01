package com.sda.olx.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDto {
@NotEmpty(message = "Email is mandatory")
@Email(message = "Email is not valid")
    private String email;
    private String password;
}
