package com.authhub.authhub.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.authhub.authhub.entities.Token;
import jakarta.transaction.Transactional;

public interface TokenQuery extends JpaRepository <Token, Integer>{
    @Query("SELECT t FROM Token t WHERE t.challenge.id = :challenge_id")
    Token findByChallengeId(Integer challenge_id);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE tokens SET token_value = :tokenValue WHERE client_challenge_id = :challengeId", nativeQuery = true)
    void updateData(@Param("tokenValue") String tokenValue, @Param("challengeId") Integer challengeId);

}