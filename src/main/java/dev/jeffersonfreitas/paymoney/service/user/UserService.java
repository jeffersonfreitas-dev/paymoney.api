package dev.jeffersonfreitas.paymoney.service.user;

import dev.jeffersonfreitas.paymoney.dto.UserCreateRequest;
import dev.jeffersonfreitas.paymoney.dto.UserResponse;

import java.util.List;

public interface UserService {
    void create(UserCreateRequest request);

    List<UserResponse> fetchAll();
}
