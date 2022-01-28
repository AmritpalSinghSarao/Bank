package com.example.Bank.controller;

import com.example.Bank.model.Account;
import com.example.Bank.model.Transaction;
import com.example.Bank.service.impl.AccountService;
import com.example.Bank.service.impl.ClientService;
import com.example.Bank.service.impl.EmployeeService;
import com.example.Bank.service.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientAccountController{

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/client/account/{id}/{pageNumber}")
    public List<Transaction> fetchAllTransactions(@PathVariable("id") Long accountNumber,@PathVariable("pageNumber") int pageNumber)
    {
        //return transactionService.fetchAllTransactionByAccount(accountNumber,pageNumber);
        return null;
    }

    @GetMapping("/client/account/{accountNumber}")
    public List<Transaction> fetchAllTransactions(Long accountNumber) {
        return null;
    }

    @PostMapping("/client/deposit/{accountNumber}/{amount}")
    public void depositMoney(@PathVariable("accountNumber") Long accountNumber,@PathVariable("amount") float amount)
    {
        //accountService.
    }

}
