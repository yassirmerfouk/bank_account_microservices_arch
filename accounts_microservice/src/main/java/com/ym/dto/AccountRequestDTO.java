package com.ym.dto;

import com.ym.model.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor @Setter @Getter @Builder
public class AccountRequestDTO {
    private double balance;
    private String CURRENCY;
    private AccountType accountType;
    private Long customerId;
}
