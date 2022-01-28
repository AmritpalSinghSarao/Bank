package com.example.Bank.model;


import com.example.Bank.global.Variables;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity
public class Transaction {

    @Id
    @SequenceGenerator(name ="transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "transaction_sequence")
    private Long transactionId;

    @Column(nullable = false)
    private float transactionAmount;

    @Temporal(TemporalType.DATE)
    private Date date;

   /* @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    @JoinTable(
            name = "transaction_account_map",
            joinColumns =
                    {
                            @JoinColumn(
                                    name = "transaction_id",
                                    referencedColumnName = "transactionId"
                            )
                    },
            inverseJoinColumns = {
                    @JoinColumn(name = "account_number",
                    referencedColumnName = "accountNumber")
            }
    )
    private List<Account> accounts;
    */
    @ManyToOne
    @JoinColumn(name = "account_number",referencedColumnName = "accountNumber")
    private Account account;

    @Column(nullable = false)
    private String description;

}
