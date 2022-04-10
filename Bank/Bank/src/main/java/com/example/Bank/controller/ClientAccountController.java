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
public class ClientAccountController implements InterfaceController{

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private TransactionService transactionService;


}
