package com.blog.payload;

import com.blog.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class UserDto {

	private Integer id;
	private String email;

	private String name;
	private String about;

}
