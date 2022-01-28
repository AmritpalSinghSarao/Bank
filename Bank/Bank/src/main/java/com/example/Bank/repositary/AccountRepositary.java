package com.example.Bank.repositary;

import com.example.Bank.model.Account;
import com.example.Bank.model.Client;
import com.example.Bank.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AccountRepositary extends JpaRepository<Account,Long>
{
    //Finding
    Account findByAccountNumber(Long accountNumber);

    int deleteByAccountNumber(Long accountNumber);

    @Query(value = "SELECT balance_account FROM Account where Account.account_number==:accountNumber",nativeQuery = true)
    float getAccountBalance(@Param("accountNumber") Long accountNumber);

    @Query(value = "SELECT * FROM Account where Account.client_id==:clientId",nativeQuery = true)
    Account findByClientId(@Param("clientId") Long clientId);

    // Deleting
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Account where Account.client_id==:clientId",nativeQuery = true)
    int deleteByClientId(Long clientId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE account a set a.balance_account=:balanceAccount WHERE a.accountNumber==:accountNumber",nativeQuery = true)
    int updateBalanceByAccountNumber(@Param("balanceAccount") float balanceAccount,@Param("accountNumber") Long accountNumber);
}
