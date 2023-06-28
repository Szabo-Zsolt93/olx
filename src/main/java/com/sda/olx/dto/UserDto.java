package com.sda.olx.dto;

import jakarta.persistence.Entity;
import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dataOfBirth;

}
