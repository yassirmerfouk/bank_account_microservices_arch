package com.ym;

import com.ym.client.CustomerClient;
import com.ym.model.Account;
import com.ym.model.AccountType;
import com.ym.model.Customer;
import com.ym.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountsMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsMicroserviceApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AccountRepository accountRepository,
                                               CustomerClient customerClient
    ){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Customer customer1 = customerClient.getCustomer(1L);
                Customer customer2 = customerClient.getCustomer(2L);
                Account account1 = Account.builder()
                        .id(UUID.randomUUID().toString())
                        .balance(1000 + Math.random() * 90000)
                        .createdAt(LocalDate.now())
                        .CURRENCY(Math.random() < 0.5 ? "EUR" : "MAD")
                        .accountType(Math.random() < 0.5 ? AccountType.CURRENT : AccountType.SAVING)
                        .customerId(customer1.getId())
                        .build();
                Account account2 = Account.builder()
                        .id(UUID.randomUUID().toString())
                        .balance(1000 + Math.random() * 90000)
                        .createdAt(LocalDate.now())
                        .CURRENCY(Math.random() < 0.5 ? "EUR" : "MAD")
                        .accountType(Math.random() < 0.5 ? AccountType.CURRENT : AccountType.SAVING)
                        .customerId(customer2.getId())
                        .build();
                accountRepository.save(account1);
                accountRepository.save(account2);

            }
        };
    }
}
