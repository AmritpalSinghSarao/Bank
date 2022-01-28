package com.example.Bank.repositary;

import com.example.Bank.model.Account;
import com.example.Bank.model.Client;
import com.example.Bank.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class AccountRepositaryTest {

    @Autowired
    private AccountRepositary accountRepositary;

    @Test
    public void saveAccount()
    {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("1997-11-06");
            Person person = Person.builder().firstName("Komal")
                    .lastName("Sarao")
                    .DateOfBirth(date)
                    .docId("X233")
                    .email("komalsarao95@yahoo.it")
                    .phone("647864228").build();

            Client client = Client.builder().person(person).build();
            Account account = Account.builder().client(client).balanceAccount(3424).build();
            accountRepositary.save(account);

        } catch (ParseException e) {}
    }
}