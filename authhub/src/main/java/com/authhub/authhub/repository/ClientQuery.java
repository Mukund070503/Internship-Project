package com.authhub.authhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.authhub.authhub.entities.Client;

public interface ClientQuery extends JpaRepository <Client, Integer>{
@Query(value = "Select service_id ,Client_name ,client_secret FROM clients WHERE client_id= :client_id", nativeQuery = true)
    public List<Object> getData(String client_id);

@Query(value="Select * FROM clients", nativeQuery = true)
    public List<Client> allClients();
}

