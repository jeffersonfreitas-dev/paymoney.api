package dev.jeffersonfreitas.paymoney.mappers;

import dev.jeffersonfreitas.paymoney.dto.UserCreateRequest;
import dev.jeffersonfreitas.paymoney.dto.UserResponse;
import dev.jeffersonfreitas.paymoney.model.User;

public class UserMapper {

    public static User toEntity(UserCreateRequest request){
        return new User(request.name());
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(user.getUuid(), user.getName());
    }
}
