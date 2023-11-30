package com.ym.mapper;

import com.ym.dto.AccountRequestDTO;
import com.ym.dto.AccountResponseDTO;
import com.ym.dto.CustomerResponseDTO;
import com.ym.model.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account toAccount(AccountRequestDTO accountRequestDTO){
        Account account = new Account();
        BeanUtils.copyProperties(accountRequestDTO, account);
        return account;
    }

    public AccountResponseDTO toAccountResponseDTO(Account account){
        AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
        BeanUtils.copyProperties(account, accountResponseDTO);
        if(account.getCustomer() != null){
            accountResponseDTO.setCustomerResponseDTO(new CustomerResponseDTO());
            BeanUtils.copyProperties(account.getCustomer(), accountResponseDTO.getCustomerResponseDTO());
        }
        return accountResponseDTO;
    }
}
