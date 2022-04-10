package com.example.Bank.controller;
import com.example.Bank.model.Account;
import com.example.Bank.model.Client;
import com.example.Bank.model.Transaction;
import com.example.Bank.service.impl.AccountService;
import com.example.Bank.service.impl.ClientService;
import com.example.Bank.service.impl.EmployeeService;
import com.example.Bank.service.impl.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController implements InterfaceController{

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

    @GetMapping("/employee/getaccount/{clientId}")
    public Account getAccount(@PathVariable Long clientId)
    {
        Account account=accountService.getAccountById(clientId);
        LOGGER.info("Account Information fetched");
        return account;
    }

    @GetMapping("/employee/deleteaccount/{accountNumber}")
    public void deleteAccount(@PathVariable Long accountNumber)
    {

        int result=accountService.deleteAccount(accountNumber);
        LOGGER.info("Account Information fetched");
    }

    // Withdraw and deposit
    @PostMapping("/employee/addTransaction")
    public Transaction addTransaction(@RequestBody Transaction trasnsaction)
    {
        LOGGER.info("Transaction added successfully");
        return transactionService.saveTransaction(trasnsaction);
    }


    // send transaction
    @PostMapping("/employee/addTransaction/{from}/{to}/{amount}")
    public Transaction sendTransaction(@PathVariable Long accountNumberFrom
                                        ,@PathVariable Long accountNumberTo
                                        ,@PathVariable Float amount)
    {
        Account accountFrom = accountService.getAccountById(accountNumberFrom);
        Account accountTo = accountService.getAccountById(accountNumberTo);

        if (accountFrom==null && accountTo==null)
        {
            LOGGER.info("Account numbers not found");
            return null;
        }

        Transaction transactionFrom = Transaction.builder()
                .transactionAmount((-amount))
                .description("Transaction sent to "+accountNumberTo)
                .account(accountFrom)
                .build();


        Transaction transactionTo = Transaction.builder()
                .transactionAmount(amount)
                .description("Transaction received from "+accountNumberTo)
                .account(accountTo)
                .build();

        transactionService.saveTransaction(transactionTo);
        return transactionService.saveTransaction(transactionFrom);
    }

    @GetMapping("/employee/getransactions/{clientId}")
    public List<Transaction> getTransactions(@PathVariable Long clientId)
    {
        Account account=accountService.getAccountById(clientId);
        List<Transaction> transactions= transactionService.fetchAllTransactionByAccount(account.getAccountNumber());
        return transactions;
    }

    @GetMapping("/employee/getclients")
    public List<Client> getClients()
    {
        return clientService.fetchAllClients();
    }
}
