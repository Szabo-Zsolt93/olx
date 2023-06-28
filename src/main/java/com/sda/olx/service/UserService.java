package com.sda.olx.service;

import com.sda.olx.dto.UserDto;
import com.sda.olx.entity.User;
import com.sda.olx.mapper.UserMapper;
import com.sda.olx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDto userDto) {
    User user = userMapper.map(userDto);
    userRepository.save(user);

    }


}
