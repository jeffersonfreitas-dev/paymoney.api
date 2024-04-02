package dev.jeffersonfreitas.paymoney.config;

import dev.jeffersonfreitas.paymoney.exceptions.ExceptionResponse;
import dev.jeffersonfreitas.paymoney.exceptions.UserAlreadyExistsException;
import dev.jeffersonfreitas.paymoney.exceptions.UserInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdviceConfig {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ExceptionResponse handleUserAlreadyExistsException(UserAlreadyExistsException e){
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserInvalidException.class)
    public ExceptionResponse handleUserInvalidException(UserInvalidException e){
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}
