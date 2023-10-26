package com.example.bankaccountservice.web;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.entities.Customer;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import com.example.bankaccountservice.repositories.CustomerRepository;
import com.example.bankaccountservice.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BankAccountService accountService;

    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount BankAccountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Account %s not found" , id)));
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id, @Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
         bankAccountRepository.deleteById(id);
         return true;
    }
    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }


}

/*
record BankAccountDTO(Double balance , String type , String currency){

}*/
