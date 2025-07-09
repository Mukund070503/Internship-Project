package com.authhub.authhub.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "tokens")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "client_challenge_id")
    private ClientChallenge challenge;

    @Column(name = "token_type", nullable = false)
    private String tokenType;

    @Column(name = "token_value", nullable = false)
    private String tokenValue;

    @Column(name = "challenge_value", nullable = false, unique = true)
    private String challengeValue;

    @Column(name = "issued_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime issuedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientChallenge getChallenge() {
        return challenge;
    }

    public void setChallenge(ClientChallenge challenge) {
        this.challenge = challenge;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public String getChallengeValue() {
        return challengeValue;
    }

    public void setChallengeValue(String challengeValue) {
        this.challengeValue = challengeValue;
    }

    public LocalDateTime getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(LocalDateTime issuedAt) {
        this.issuedAt = issuedAt;
    }
}
