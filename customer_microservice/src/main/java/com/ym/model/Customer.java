package com.ym.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Setter @Getter @Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public void copy(Customer customer){
        if(customer.firstName != null)
            this.firstName = customer.firstName;
        if(customer.lastName != null)
            this.lastName = customer.lastName;
        if(customer.email != null)
            this.email = customer.email;
    }
}
