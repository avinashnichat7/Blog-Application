package com.blog.controller;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.UserDto;
import com.blog.service.UserService;
import org.hibernate.cache.spi.entry.StructuredCacheEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {

        UserDto saveUser = userService.createUser(userDto);

       // return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
        return  ResponseEntity.status(HttpStatus.CREATED ).body(saveUser);

    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUsers(@RequestBody UserDto userDto, @PathVariable("userId") Integer userId) {

        UserDto updateUser = userService.updateUser(userDto, userId);

        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
        // return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/{userId}")

    //   if we are not Using any ApiResponse class for message then we are following this
//    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer id){
//
//        this.userService.deleteById(id);
// return new  ResponseEntity(Map.of("message", "User Deleted Sucessfully")),HttpStatus.OK);
    // or
// return new  ResponseEntity(Map.of("message", "User Deleted Sucessfully")),HttpStatus.OK);


    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer id) {

        userService.deleteById(id);

return  ResponseEntity.
        status(HttpStatus.OK).body( new ApiResponse("user deleted sucessfully", true ));


    }
    @GetMapping("/allUser")
    public ResponseEntity<List<UserDto>> getAllUser() {

        List<UserDto> allUser = this.userService.getAllUser();


        return new ResponseEntity<>(HttpStatus.OK);


    }

    @GetMapping("/userId")
    public ResponseEntity<UserDto> getSingleUSer(@PathVariable("userId") Integer id) {

        UserDto userById = this.userService.getUserById(id);

        return ResponseEntity.status(HttpStatus.OK).body(userById);
    }

}
