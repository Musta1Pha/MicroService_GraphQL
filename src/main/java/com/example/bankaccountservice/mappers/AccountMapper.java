package com.example.bankaccountservice.mappers;

import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        bankAccountResponseDTO.setId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);

        return bankAccountResponseDTO;
    }

}
