package com.example.Bank.service;

import com.example.Bank.model.Account;
import com.example.Bank.model.Client;
import com.example.Bank.repositary.AccountRepositary;
import com.example.Bank.repositary.ClientRepositary;
import com.example.Bank.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepositary accountRepositary;

    @Autowired
    private ClientRepositary clientRepositary;

    @Override
    public List<Account> fetchAllAccounts() {
        return accountRepositary.findAll();
    }

    public Account saveAccount(Account account, Client client)
    {
        Account accountAdd =Account.builder()
                .accountNumber(account.getAccountNumber())
                .balanceAccount(0)
                .client(client)
                .build();

        accountRepositary.save(accountAdd);
        return accountAdd;
    }

    public int deleteAccount(Long accountNumber)
    {
        return accountRepositary.deleteByAccountNumber(accountNumber);
    }

    public Account updateAccountBalance(float balanceToAdd,Long accountNumber)
    {
        float accountBalance= accountRepositary.getAccountBalance(accountNumber);
        accountBalance = accountBalance + balanceToAdd;
        accountRepositary.updateBalanceByAccountNumber(accountBalance,accountNumber);
        return accountRepositary.findByAccountNumber(accountNumber);
    }

    public Account getAccountById(Long clientId)
    {
        return accountRepositary.findByClientId(clientId);
    }

}
