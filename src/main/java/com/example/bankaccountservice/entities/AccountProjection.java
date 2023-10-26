package com.example.bankaccountservice.entities;

import com.example.bankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

// Utilisation du mécanisme de projection afin de préciser les colonnes souhaitées
@Projection(types = BankAccount.class , name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
