package com.example.Bank.controller;

import com.example.Bank.service.impl.AccountService;
import com.example.Bank.service.impl.ClientService;
import com.example.Bank.service.impl.EmployeeService;
import com.example.Bank.service.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private EmployeeService employeeService;


}
