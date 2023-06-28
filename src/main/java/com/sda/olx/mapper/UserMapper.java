package com.sda.olx.mapper;

import com.sda.olx.dto.UserDto;
import com.sda.olx.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {

    public User map(UserDto userDto){
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .dateOfBirth(LocalDate.parse(userDto.getDataOfBirth()))
                .build();
    }

//    public UserDto map(User user){
//        return UserDto.builder()
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
//                .email(user.getEmail())
//                .dataOfBirth(user.getDateOfBirth().toString())
//                .build();
//    }

}
