package com.ym.web;

import com.ym.dto.CustomerRequestDTO;
import com.ym.dto.CustomerResponseDTO;
import com.ym.model.Customer;
import com.ym.repository.CustomerRepository;
import com.ym.service.CustomerService;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponseDTO> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponseDTO getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDTO addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.addCustomer(customerRequestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponseDTO updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerRequestDTO customerRequestDTO
            ){
        return customerService.updateCustomer(id, customerRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }

}
