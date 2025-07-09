package com.authhub.authhub.entities;

public class TokenResponseDTO {
    private String Token_Message;
    private String Challenge_val;

    public TokenResponseDTO(String Token_Message, String Challenge_val) {
        this.Token_Message = Token_Message;
        this.Challenge_val = Challenge_val;
    }

    public String getToken_Message() {
        return Token_Message;
    }

    public String getChallenge_val() {
        return Challenge_val;
    }

    public void setToken_Message(String Token_Message) {
        this.Token_Message = Token_Message;
    }

    public void setToken(String Challenge_val) {
        this.Challenge_val = Challenge_val;
    }
}
