package com.example.Bank.repositary;

import com.example.Bank.model.Client;
import com.example.Bank.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositary extends JpaRepository<Employee,Long> {


}
