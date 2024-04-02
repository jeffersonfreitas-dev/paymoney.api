package dev.jeffersonfreitas.paymoney.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "users_accounts")
public class Account {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private BigDecimal balance;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
