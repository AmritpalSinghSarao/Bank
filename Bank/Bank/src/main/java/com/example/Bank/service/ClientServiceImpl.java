package com.example.Bank.service;

import com.example.Bank.model.Client;
import com.example.Bank.repositary.AccountRepositary;
import com.example.Bank.repositary.ClientRepositary;
import com.example.Bank.service.impl.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger LOGGER  = LogManager.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepositary clientRepositary;


    @Override
    public List<Client> fetchAllClients() {
        return clientRepositary.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepositary.save(client);
    }

    @Override
    public int deleteClient(Long clientId) {
        return clientRepositary.deleteByClientId(clientId);
    }

    @Override
    public Client fetchByFirstName(String firstName) {
        return clientRepositary.findByFirstNameIgnoreCase(firstName);
    }

    @Override
    public Client fetchByLastName(String lastName) {
        return clientRepositary.findByLastNameIgnoreCase(lastName);
    }

    @Override
    public Client fetchByPhone(String phone) {
        return clientRepositary.findByPhoneIgnoreCase(phone);
    }

    @Override
    public Client fetchByDocId(String docId) {
        return clientRepositary.findByDocIdIgnoreCase(docId);
    }

    @Override
    public Client fetchByEmail(String email) {
        return clientRepositary.findByEmailIgnoreCase(email);
    }

    @Override
    public int updateEmail(String email, Long clientId) {
        LOGGER.info("client email update");
        return clientRepositary.updateClientByEmail(email,clientId);
    }

    @Override
    public int updatePhone(String phone, Long clientId) {
        LOGGER.info("client phone update");
        return clientRepositary.updateClientByPhone(phone,clientId);
    }

    @Override
    public int updateDocId(String docId, Long clientId)
    {
        LOGGER.info("client docId update");
        return clientRepositary.updateClientByDocId(docId,clientId);
    }
}
