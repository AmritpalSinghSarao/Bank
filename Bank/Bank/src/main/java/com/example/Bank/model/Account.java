package com.example.Bank.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "account_sequence")
    @Column(unique = true)
    private Long accountNumber;

    @Column(nullable = false)
    private float balanceAccount;

    @OneToOne(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        // When ever we try to save course material
        // Person is mandatory
        optional = false)
    @JoinColumn(
            name = "client_id",
            referencedColumnName = "clientId"
    )
    private Client client;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

}
