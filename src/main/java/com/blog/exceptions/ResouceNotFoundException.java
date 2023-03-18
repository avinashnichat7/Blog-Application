package com.blog.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data

@NoArgsConstructor
public class ResouceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    long fieldValue;

    public ResouceNotFoundException(String resourceName, String fieldName, long fieldValue) {

        super(String.format("%s not found with %s: %1", resourceName, fieldName, fieldValue));
        this.resourceName=resourceName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }


}
