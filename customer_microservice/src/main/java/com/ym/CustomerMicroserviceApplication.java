package com.ym;

import com.ym.model.Customer;
import com.ym.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerMicroserviceApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Customer customer1 = Customer.builder()
                        .firstName("Yassir")
                        .lastName("Merfouk")
                        .email("yassirmerfouk@gmail.com")
                        .build();
                Customer customer2 = Customer.builder()
                        .firstName("Ym")
                        .lastName("Merfouk")
                        .email("ym@gmail.com")
                        .build();
                customerRepository.save(customer1);
                customerRepository.save(customer2);
            }
        };
    }
}
