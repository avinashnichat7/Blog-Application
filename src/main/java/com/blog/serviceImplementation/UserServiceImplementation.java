package com.blog.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.User;
import com.blog.payload.UserDto;
import com.blog.repository.UserRepository;
import com.blog.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
	User user =this.dtoToUser(userDto);
		User saveUser = this.userRepository.save(user);
		// TODO Auto-generated method stub
		return this.userToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		
		this.userRepository.findById(userId).orElseThrow((s)-> 
		new ResourceNotFoundException("USer ", ))
		 
		return null;
	}

	@Override
	public List<UserDto> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub

	}

	public User dtoToUser(UserDto userDto) {

		User user = new User();

		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());

		return user;
	}

	public UserDto userToDto(User user) {

		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setAbout(user.getAbout());
		return userDto;
	}
}
