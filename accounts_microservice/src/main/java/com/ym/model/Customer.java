package com.ym.model;

import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Setter @Getter @Builder
public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
