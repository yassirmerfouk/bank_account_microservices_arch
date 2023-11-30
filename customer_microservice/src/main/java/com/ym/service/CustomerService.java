package com.ym.service;

import com.ym.dto.CustomerRequestDTO;
import com.ym.dto.CustomerResponseDTO;
import com.ym.mapper.CustomerMapper;
import com.ym.model.Customer;
import com.ym.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerResponseDTO addCustomer(CustomerRequestDTO customerRequestDTO){
        Customer customer = customerMapper.toCustomer(customerRequestDTO);
        customerRepository.save(customer);
        return customerMapper.toCustomerResponseDTO(customer);
    }

    public CustomerResponseDTO updateCustomer(Long id, CustomerRequestDTO customerRequestDTO){
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Customer " +id+ " not found")
        );
        customer.copy(customerMapper.toCustomer(customerRequestDTO));
        customerRepository.save(customer);
        return customerMapper.toCustomerResponseDTO(customer);
    }

    public void deleteCustomer(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Customer " +id+ " not found")
        );
        customerRepository.delete(customer);
    }

    public List<CustomerResponseDTO> getCustomers(){
        return customerRepository.findAll().stream().map(
                customer -> customerMapper.toCustomerResponseDTO(customer)
        ).collect(Collectors.toList());
    }

    public CustomerResponseDTO getCustomer(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Customer " +id+ " not found")
        );
        return customerMapper.toCustomerResponseDTO(customer);
    }
}
