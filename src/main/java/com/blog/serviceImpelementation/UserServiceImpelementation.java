package com.blog.serviceImpelementation;

import com.blog.entities.User;
import com.blog.exceptions.ResouceNotFoundException;
import com.blog.payloads.UserDto;
import com.blog.repository.UserRepository;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpelementation implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
//        Optional<User> existingUser = this.userRepository.findById(userId);
//
//        if (existingUser.isPresent()) {
//
//            User user = existingUser.get();
//            user.setEmail(existingUser.get().getEmail());
//            user.setName(existingUser.get().getName());
//            user.setPassword(existingUser.get().getPassword());
//            user.setAbout(existingUser.get().getAbout());
//        } else {
//
//            throw new ResouceNotFoundException("User", "Id", userId);
//        }
        User existingUser = this.userRepository.findById(userId).get();

        if (existingUser.getName() == null) {

            throw new ResouceNotFoundException("User", "ID", userId);

        } else {
            existingUser.setName(userDto.getName());
        }
        if (existingUser.getEmail() == null) {
            throw new ResouceNotFoundException("User", "Id", userId);
        } else {
            existingUser.setAbout(userDto.getAbout());
        }
if(existingUser.getAbout()==null){
    throw new ResouceNotFoundException("User", "Id", userId);
}else {

    existingUser.setAbout(userDto.getAbout());}

    if(existingUser.getPassword()==null){
        throw new ResouceNotFoundException("User", "Id", userId);
    }else {

        existingUser.setPassword(userDto.getPassword());
    }
    User updateUser=    this.userRepository.save(existingUser);

 UserDto updatedUserDto=   this.userToDto(updateUser);

    return updatedUserDto;
    }

    @Override
    public UserDto getUserById(Integer userId) {


       User user= this.userRepository.findById(userId).orElseThrow(()->
                new ResouceNotFoundException("User", "Id", userId));

        return this.userToDto(user);
    }


    @Override
    public List<UserDto> getAllUser() {

        List<User> user = this.userRepository.findAll();

        List<UserDto> dtoList = user.stream().map(u -> this.userToDto(u)).collect(Collectors.toList());
        return dtoList;
    }

    
    @Override
    public void deleteById(Integer userId) {


        User user = this.userRepository.findById(userId).
                orElseThrow(() -> new ResouceNotFoundException("User", "Id", userId));

       this. userRepository.delete(user);

    }


    private User dtoToUser(UserDto userDto) {

        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(user.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private UserDto userToDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setAbout(userDto.getAbout());
        userDto.setPassword(user.getPassword());

        return userDto;
    }
}
