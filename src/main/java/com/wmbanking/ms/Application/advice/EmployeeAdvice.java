package com.wmbanking.ms.Application.advice;

import com.wmbanking.ms.Application.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class EmployeeAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFoundGracefulMessage(NotFoundException ex){
        return ex.getMessage();
    }
}
