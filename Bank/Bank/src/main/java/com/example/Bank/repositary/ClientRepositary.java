package com.example.Bank.repositary;

import com.example.Bank.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClientRepositary extends JpaRepository<Client,Long> {

    @Override
    List<Client> findAll();

    // Find clients
    @Query(value = "SELECT * FROM client where LOWER(client.firstName) like '%' + LOWER(:firstName) + '%'",nativeQuery = true)
    public Client findByFirstNameIgnoreCase(@Param("firstName") String firstName);

    @Query(value = "SELECT * FROM client where LOWER(client.lastName) like '%' + LOWER(:lastName) + '%'",nativeQuery = true)
    public Client findByLastNameIgnoreCase(@Param("lastName") String lastName);

    @Query(value = "SELECT * FROM client where LOWER(client.email) like '%' + LOWER(:email) + '%'",nativeQuery = true)
    public Client findByEmailIgnoreCase(@Param("email") String email);

    @Query(value = "SELECT * FROM client where client.phone==:phone",nativeQuery = true)
    public Client findByPhoneIgnoreCase(@Param("phone") String firstName);

    @Query(value = "SELECT * FROM client where LOWER(client.docId) like '%' + LOWER(:docId) + '%'",nativeQuery = true)
    public Client findByDocIdIgnoreCase(@Param("docId") String docId);

   // Delete client
    @Modifying
    @Query(value = "DELETE FROM client where client.clientId==:clientId",nativeQuery = true)
    int deleteByClientId(@Param("clientId") Long clientId);

    // Update new client
    @Modifying
    @Transactional
    @Query(value = "UPDATE Client c SET c.email=:email where c.client_id==clientId",nativeQuery = true)
    int updateClientByEmail(@Param("email") String email,@Param("clientId")Long clientId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Client c SET c.phone=:phone where c.client_id==clientId",nativeQuery = true)
    int updateClientByPhone(@Param("phone") String email,@Param("clientId")Long clientId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Client c SET c.docId=:docId where c.client_id==clientId",nativeQuery = true)
    int updateClientByDocId(@Param("docId") String docId,@Param("clientId")Long clientId);

}
