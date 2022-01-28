package com.example.Bank.repositary;

import com.example.Bank.model.Account;
import com.example.Bank.model.Employee;
import com.example.Bank.model.Person;
import com.example.Bank.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionRepositaryTest {

    @Autowired
    private TransactionRepositary transactionRepositary;

    @Autowired
    private AccountRepositary accountRepositary;


    @Test
    public void saveTransaction()
    {
        Long accountNumber = 102L;
        //float amount = accountRepositary.getAccountBalance(accountNumber);
        Account account = accountRepositary.findByAccountNumber(accountNumber);
        List<Account> accounts = Arrays.asList(account);

        Date date = new Date();

        Transaction transaction = Transaction.builder()
                .transactionAmount(78)
                .description("thgj")
                .account(account)
                .date(date)
                .build();
        transactionRepositary.save(transaction);
    }
}