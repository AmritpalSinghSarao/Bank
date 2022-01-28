package com.example.Bank.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @SequenceGenerator(name ="employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "employee_sequence")
    private Long employeeId;

    @Column( nullable = false)
    private float salaryYear;

    @Embedded
    private Person person;
}
