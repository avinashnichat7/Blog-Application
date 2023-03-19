package com.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.payload.UserDto;

/**
 * @author user
 */

@Service
public interface UserService {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer id);

	List<UserDto> getAllUser();

	UserDto getUserById(Integer id);

	void deleteUser(Integer id);
}
