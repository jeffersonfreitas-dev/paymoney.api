package dev.jeffersonfreitas.paymoney.service.user;

import dev.jeffersonfreitas.paymoney.dto.UserCreateRequest;
import dev.jeffersonfreitas.paymoney.dto.UserResponse;
import dev.jeffersonfreitas.paymoney.exceptions.UserAlreadyExistsException;
import dev.jeffersonfreitas.paymoney.exceptions.UserInvalidException;
import dev.jeffersonfreitas.paymoney.mappers.UserMapper;
import dev.jeffersonfreitas.paymoney.model.User;
import dev.jeffersonfreitas.paymoney.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void create(UserCreateRequest request) {
        if(request == null)
            throw new UserInvalidException("Request cannot be null");

        verifyIfAlreadyExists(request);
        User entity = UserMapper.toEntity(request);
        repository.save(entity);
        log.info("User created with name {} successfully", entity.getName());
    }

    @Override
    public List<UserResponse> fetchAll() {
        return repository.findAll().stream()
                .map(UserMapper::toResponse)
                .sorted().collect(Collectors.toList());
    }

    private void verifyIfAlreadyExists(UserCreateRequest request) {
        Optional<User> optUser = repository.findByNameIgnoreCase(request.name());
        if(optUser.isPresent())
            throw new UserAlreadyExistsException( String.format("User with name %s already exists", request.name()));
    }
}
