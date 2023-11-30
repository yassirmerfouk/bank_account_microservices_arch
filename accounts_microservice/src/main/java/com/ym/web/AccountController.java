package com.ym.web;

import com.ym.client.CustomerClient;
import com.ym.dto.AccountRequestDTO;
import com.ym.dto.AccountResponseDTO;
import com.ym.model.Account;
import com.ym.model.Customer;
import com.ym.repository.AccountRepository;
import com.ym.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @GetMapping
    public List<AccountResponseDTO> getAccounts(){
        return accountService.getAccounts();
    }

    @GetMapping("{id}")
    public AccountResponseDTO getAccount(@PathVariable String id){
        return accountService.getAccount(id);
    }

    @PostMapping
    public AccountResponseDTO addAccount(@RequestBody AccountRequestDTO accountRequestDTO){
        return accountService.addAccount(accountRequestDTO);
    }
}
