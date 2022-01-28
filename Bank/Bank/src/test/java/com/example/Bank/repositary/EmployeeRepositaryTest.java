package com.example.Bank.repositary;

import com.example.Bank.model.Account;
import com.example.Bank.model.Client;
import com.example.Bank.model.Employee;
import com.example.Bank.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositaryTest {

    @Autowired
    private EmployeeRepositary employeeRepositary;

    @Test
    public void saveEmployee() {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse("1993-10-07");
            Person person = Person.builder().firstName("Marc")
                    .lastName("Ed")
                    .DateOfBirth(date)
                    .docId("X256")
                    .email("marced@yahoo.it")
                    .phone("6478637636").build();

            Employee employee = Employee.builder().person(person).salaryYear(58000).build();
            employeeRepositary.save(employee);

        } catch (ParseException e) {
        }
    }


}