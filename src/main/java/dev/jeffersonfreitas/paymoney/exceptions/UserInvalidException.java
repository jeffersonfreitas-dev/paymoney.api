package dev.jeffersonfreitas.paymoney.exceptions;

public class UserInvalidException extends RuntimeException{

    public UserInvalidException(String message) {
        super(message);
    }
}
