package com.example.Bank.service;

import com.example.Bank.model.Transaction;
import com.example.Bank.repositary.TransactionRepositary;
import com.example.Bank.service.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepositary transactionRepositary;


    @Override
    public List<Transaction> fetchAllTransactionByAccount(Long accountNumber) {
        return transactionRepositary.findByAccountNumber(accountNumber);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepositary.save(transaction);
    }
}
