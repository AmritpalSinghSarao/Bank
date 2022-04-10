package com.example.Bank.service.impl;

import com.example.Bank.model.Account;
import com.example.Bank.model.Client;
import com.example.Bank.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {

    public List<Account> fetchAllAccounts();
    public Account saveAccount(Account account, Client client);
    public int deleteAccount(Long accountNumber);
    public Account updateAccountBalance(float balanceToAdd,Long accountNumber);
    public Account getAccountById(Long clientId);

}
