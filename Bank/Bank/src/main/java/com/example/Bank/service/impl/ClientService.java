package com.example.Bank.service.impl;

import com.example.Bank.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ClientService {
    public List<Client> fetchAllClients();
    public Client saveClient(Client client);
    public int deleteClient(Long clientId);
    public Client fetchByFirstName(String firstName);
    public Client fetchByLastName(String lastName);
    public Client fetchByPhone(String phone);
    public Client fetchByDocId(String docId);
    public Client fetchByEmail(String email);
    public int updateEmail(String email,Long clientId);
    public int updatePhone(String phone,Long clientId);
    public int updateDocId(String docId,Long clientId);
}
