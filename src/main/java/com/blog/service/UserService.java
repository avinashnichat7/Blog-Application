package com.blog.service;

import com.blog.entities.User;
import com.blog.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);


    List<UserDto> getAllUser();

    void deleteById(Integer userId);

}
