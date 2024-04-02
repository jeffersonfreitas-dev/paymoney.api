package dev.jeffersonfreitas.paymoney.repository;

import dev.jeffersonfreitas.paymoney.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNameIgnoreCase(String name);
}
