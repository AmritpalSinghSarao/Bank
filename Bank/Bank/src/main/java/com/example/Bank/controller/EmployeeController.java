package com.example.Bank.controller;

import com.example.Bank.model.Account;
import com.example.Bank.model.Client;
import com.example.Bank.service.impl.AccountService;
import com.example.Bank.service.impl.ClientService;
import com.example.Bank.service.impl.EmployeeService;
import com.example.Bank.service.impl.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private AccountService accountService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee/addaccount")
    public void addNewAccount(@RequestBody Account account,@RequestBody Client client)
    {
        accountService.saveAccount(account,client);
        LOGGER.info("New account saved successfully");
    }

    @GetMapping("/employee/getaccount")
    public Account getAccount(Client client)
    {
        accountService.getAccountById()
        LOGGER.info("Account Information fetched");
    }





}
