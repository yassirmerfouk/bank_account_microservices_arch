package com.ym.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ym.model.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor @Setter @Getter @Builder
public class AccountResponseDTO {
    private String id;
    private double balance;
    private LocalDate createdAt;
    private String CURRENCY;
    private AccountType accountType;

    @JsonProperty("customer")
    private CustomerResponseDTO customerResponseDTO;
}
