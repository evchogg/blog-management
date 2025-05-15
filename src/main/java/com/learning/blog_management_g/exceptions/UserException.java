package com.learning.blog_management_g.exceptions;

import com.learning.blog_management_g.constants.ErrorType;
import lombok.Getter;

@Getter
public class UserException extends  RuntimeException{

    private final ErrorType errorType;

    public UserException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }
}
