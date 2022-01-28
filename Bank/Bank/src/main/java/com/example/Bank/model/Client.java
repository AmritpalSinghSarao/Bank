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
public class Client {

    @Id
    @SequenceGenerator(name ="client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "client_sequence")
    private Long clientId;
    @Embedded
    private Person person;

    @OneToOne(mappedBy = "client")
    private Account account;

}
