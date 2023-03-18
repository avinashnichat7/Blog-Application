package com.blog.payloads;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private String message;
    private boolean sucess;


}

