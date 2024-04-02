package dev.jeffersonfreitas.paymoney.controller;

import dev.jeffersonfreitas.paymoney.dto.UserCreateRequest;
import dev.jeffersonfreitas.paymoney.dto.UserResponse;
import dev.jeffersonfreitas.paymoney.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserCreateRequest request){
        service.create(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> fetchAll(){
        return service.fetchAll();
    }
}
