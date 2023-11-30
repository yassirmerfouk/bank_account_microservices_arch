package com.ym.service;

import com.ym.client.CustomerClient;
import com.ym.dto.AccountRequestDTO;
import com.ym.dto.AccountResponseDTO;
import com.ym.dto.CustomerResponseDTO;
import com.ym.mapper.AccountMapper;
import com.ym.model.Account;
import com.ym.model.Customer;
import com.ym.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountService {

    private AccountRepository accountRepository;
    private CustomerClient customerClient;
    private AccountMapper accountMapper;

    public AccountResponseDTO addAccount(AccountRequestDTO accountRequestDTO){
        Account account = accountMapper.toAccount(accountRequestDTO);
        try{
            Customer customer = customerClient.getCustomer(account.getCustomerId());
            account.setId(UUID.randomUUID().toString());
            account.setCreatedAt(LocalDate.now());
            account.setCustomer(customer);
            accountRepository.save(account);
        }catch(Exception e){
            throw new RuntimeException("Customer not found");
        }
        return accountMapper.toAccountResponseDTO(account);
    }

    public AccountResponseDTO getAccount(String id){
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Account not found")
        );
        Customer customer = customerClient.getCustomer(account.getCustomerId());
        account.setCustomer(customer);
        return accountMapper.toAccountResponseDTO(account);
    }

    public List<AccountResponseDTO> getAccounts(){
        List<Account> accounts = accountRepository.findAll();
        accounts.forEach(
                account -> {
                    Customer customer = customerClient.getCustomer(account.getCustomerId());
                    account.setCustomer(customer);
                }
        );
        return accounts.stream().map(
                account -> accountMapper.toAccountResponseDTO(account)
        ).collect(Collectors.toList());
    }
}
