package com.example.Bank.repositary;

import com.example.Bank.model.Client;
import com.example.Bank.model.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepositary extends JpaRepository<Transaction,Long> {

    /*
    @Query(value = "select t.transaction_id,t.transaction_amount,t.date,t.description,\n" +
            "             ta.account_number from transaction as t JOIN transaction_account_map AS ta\n" +
            "            on t.transaction_id=ta.transaction_id where ta.account_number==?1",nativeQuery = true)*/
    @Query(value = "SELECT * FROM transaction as t where t.account_number==:accountNumber",nativeQuery = true)
    List<Transaction> findByAccountNumber(@Param("accountNumber") Long accountNumber);
}
