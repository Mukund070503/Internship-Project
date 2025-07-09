package com.authhub.authhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.authhub.authhub.entities.ClientChallenge;

public interface ClientChallengeQuery extends JpaRepository <ClientChallenge, Integer>{
    @Query("SELECT c FROM ClientChallenge c WHERE c.client.clientId = :clientId")
    List<ClientChallenge> findByClientId(String clientId);
}

    