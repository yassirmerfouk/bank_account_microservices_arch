package com.ym.client;

import com.ym.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "CUSTOMER-MICROSERVICE"
)
public interface CustomerClient {

    @GetMapping("/customers/{id}")
/*    @CircuitBreaker(name = "customer-service", fallbackMethod = "getDefaultCustomer")*/
    public Customer getCustomer(@PathVariable Long id);

    default Customer getDefaultCustomer(Long id, Exception e){
        return Customer.builder()
                .id(id)
                .firstName("not available")
                .lastName("not available")
                .email("not available")
                .build();
    }
}
