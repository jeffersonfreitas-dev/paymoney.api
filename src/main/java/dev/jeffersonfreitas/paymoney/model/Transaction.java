package dev.jeffersonfreitas.paymoney.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transaction {

    @Id
    @EqualsAndHashCode.Include
    private String uuid;

    private BigDecimal amount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private TransactionStatus status;

    @ManyToOne
    @JoinColumn(name = "origin_account")
    private Account origin;

    @ManyToOne
    @JoinColumn(name = "destination_account")
    private Account destination;
}
