package dev.jeffersonfreitas.paymoney.dto;

import dev.jeffersonfreitas.paymoney.exceptions.UserInvalidException;

public record UserCreateRequest(String name) {

    public UserCreateRequest(String name) {
        this.name = validateName(name);
    }

    private String validateName(String name) {
        if (name == null || name.length() > 60)
            throw new UserInvalidException("User name must be at least 60 characters");
        return name;
    }
}
