
package com.authhub.authhub.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "client_challenges")
public class ClientChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    private Client client;

    @Column(name = "challenge_type", nullable = false)
    private String challengeType;

    @Column(name = "token_type", nullable = false)
    private String tokenType;

    @Column(name = "challenge_order")
    private Integer challengeOrder;

    @OneToOne(mappedBy = "challenge", cascade = CascadeType.ALL)
    private Token token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getChallengeType() {
        return challengeType;
    }

    public void setChallengeType(String challengeType) {
        this.challengeType = challengeType;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getChallengeOrder() {
        return challengeOrder;
    }

    public void setChallengeOrder(Integer challengeOrder) {
        this.challengeOrder = challengeOrder;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}