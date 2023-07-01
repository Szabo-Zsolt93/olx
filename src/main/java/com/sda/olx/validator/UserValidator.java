package com.sda.olx.validator;

import com.sda.olx.dto.UserDto;
import com.sda.olx.entity.User;
import com.sda.olx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Optional;

@Component
public class UserValidator {

    @Autowired
    private UserRepository userRepository;


    public void validate(UserDto userDto, BindingResult bindingResult) {
        validateEmailUnique(userDto, bindingResult);
    }


    private void validateEmailUnique(UserDto userDto, BindingResult bindingResult) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            FieldError fieldError = new FieldError("userDto", "email", "Email is already has been used");
            bindingResult.addError(fieldError);
        }
    }

}
