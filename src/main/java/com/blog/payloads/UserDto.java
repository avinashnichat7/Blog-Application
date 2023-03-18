package com.blog.payloads;

import lombok.*;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class UserDto {

    private  Integer id;
private String name;
private  String email;

private  String password;
private  String about;
}


