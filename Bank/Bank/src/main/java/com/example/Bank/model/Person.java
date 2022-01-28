package com.example.Bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Person {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String phone;

    private String email;

    @Column(nullable = false,unique = true)
    private String docId;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date DateOfBirth;
}
