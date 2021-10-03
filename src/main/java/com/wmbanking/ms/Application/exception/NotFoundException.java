package com.wmbanking.ms.Application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id){
        super("Not found Employee " + id);
    }
}
