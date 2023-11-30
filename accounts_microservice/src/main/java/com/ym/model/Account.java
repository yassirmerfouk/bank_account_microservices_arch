package com.ym.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor @AllArgsConstructor @Setter @Getter @Builder
public class Account {

    @Id
    private String id;
    private double balance;
    private LocalDate createdAt;
    private String CURRENCY;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private Long customerId;

    @Transient
    private Customer customer;
}
