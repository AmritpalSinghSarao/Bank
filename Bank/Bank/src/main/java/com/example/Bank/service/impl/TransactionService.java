package com.example.Bank.service.impl;

import com.example.Bank.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionService {

    List<Transaction> fetchAllTransactionByAccount(Long accountNumber);
    Transaction saveTransaction(Transaction transaction);


}
