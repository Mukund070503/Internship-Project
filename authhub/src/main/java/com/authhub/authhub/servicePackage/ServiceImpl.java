package com.authhub.authhub.servicePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.authhub.authhub.controllerPackage.Controller;
import com.authhub.authhub.entities.Client;
import com.authhub.authhub.entities.ClientChallenge;
import com.authhub.authhub.entities.ClientChallengeDTO;
import com.authhub.authhub.entities.ClientDTO;
import com.authhub.authhub.entities.Token;
import com.authhub.authhub.entities.TokenResponseDTO;
import com.authhub.authhub.repository.ClientQuery;
import com.authhub.authhub.repository.ClientChallengeQuery;
import com.authhub.authhub.repository.TokenQuery;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ServiceImpl implements ServiceInterface{
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Controller.class);
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ClientQuery client;
    @Autowired
    private ClientChallengeQuery challenges;
    @Autowired
    private TokenQuery token;
@Override
public List<ClientDTO> allClients() {
    List<Client> clientList = client.allClients(); 
    List<ClientDTO> dtoList = new ArrayList<>();

    for (Client c : clientList) {
        ClientDTO dto = new ClientDTO();
        dto.setId(c.getId());
        dto.setClientId(c.getClientId());
        dto.setClientName(c.getClientName());
        dto.setServiceId(c.getServiceId());
        dtoList.add(dto);
    }

    return dtoList;
}

    public Object PanOutput(ClientChallengeDTO challengeInfo) {
        Token tokenInfo = null;
        try {
            logger.info("Received PAN challenge request: {}", challengeInfo);
    
            List<Object> clientDetails = client.getData(challengeInfo.getClient_id());
            if (clientDetails == null || clientDetails.isEmpty()) {
                logger.warn("Client not found for client_id: {}", challengeInfo.getClient_id());
                return "Client not found";
            }
            
            Object[] row = (Object[]) clientDetails.get(0);
            String dbClientSecret = (String) row[2];
            
            if (!challengeInfo.getClient_secret().equals(dbClientSecret)) {
                logger.warn("Client secret mismatch for client_id: {}", challengeInfo.getClient_id());
                return "Client secret mismatch";
            }
            
            List<ClientChallenge> challengeList = challenges.findByClientId(challengeInfo.getClient_id());
            logger.info("Total challenges fetched for client_id {}: {}", challengeInfo.getClient_id(), challengeList.size());
            challengeList.sort((a, b) -> Integer.compare(a.getChallengeOrder(), b.getChallengeOrder()));
            String tokenVal = null;
            int x = 0;
            Integer challengeId = null;
            for (ClientChallenge ch : challengeList) {
                logger.info("Checking challenge: {}", ch);
                challengeId = ch.getId();
                if (ch.getChallengeType().equalsIgnoreCase("pan") &&
                    challengeInfo.getPan_number() != null &&
                    challengeInfo.getPan_number().equals(token.findByChallengeId(ch.getId()).getChallengeValue())) {
                    
                    logger.info("PAN number matched for challenge_id: {}", ch.getId());

                    if (ch.getChallengeOrder() == 1) {
                        tokenVal = UUID.randomUUID().toString();
                        x++;
                        tokenInfo = token.findByChallengeId(ch.getId());
                        logger.info("Generated token for order 1: {}", tokenVal);
                        continue;
                    } else {
                        tokenInfo = token.findByChallengeId(ch.getId());
                        logger.info("Checking challenge: {}", tokenInfo.getTokenValue());
                        logger.info("Checking challenge: {}", challengeInfo.getToken_value());
                        if (challengeInfo.getToken_value() != null &&
                            challengeInfo.getToken_value().equals(tokenInfo.getTokenValue())) {
                            logger.info("Token matched successfully for challenge_id: {}", ch.getId());
                            return new TokenResponseDTO("Token matched", tokenInfo.getChallengeValue());
                        } else {
                            logger.warn("Token mismatch for challenge_id: {}", ch.getId());
                            return new TokenResponseDTO("Token mismatch", null);
                        }
                    }
                    
                } 
            }
            
            if (x == 1) {
                logger.info("Updating token for challenge_id (order 2): {}",challengeId);
                token.updateData(tokenVal, challengeId);
                return new TokenResponseDTO(tokenVal, tokenInfo.getChallengeValue());
            }
    
            logger.warn("No matching PAN challenge found.");
            return "No matching challenge found";
    
        } catch (Exception e) {
            logger.error("Error occurred in PanOutput: ", e);
            return "Error occurred";
        }
    }
    public Object AdharOutput(ClientChallengeDTO challengeInfo) {
        Token tokenInfo = null;
        try {
            logger.info("Received Aadhar challenge request: {}", challengeInfo);
    
            List<Object> clientDetails = client.getData(challengeInfo.getClient_id());
            if (clientDetails == null || clientDetails.isEmpty()) {
                logger.warn("Client not found for client_id: {}", challengeInfo.getClient_id());
                return "Client not found";
            }
    
            Object[] row = (Object[]) clientDetails.get(0);
            String dbClientSecret = (String) row[2];
    
            if (!challengeInfo.getClient_secret().equals(dbClientSecret)) {
                logger.warn("Client secret mismatch for client_id: {}", challengeInfo.getClient_id());
                return "Client secret mismatch";
            }
    
            List<ClientChallenge> challengeList = challenges.findByClientId(challengeInfo.getClient_id());
            logger.info("Total challenges fetched for client_id {}: {}", challengeInfo.getClient_id(), challengeList.size());
            challengeList.sort((a, b) -> Integer.compare(a.getChallengeOrder(), b.getChallengeOrder()));
            String tokenVal = null;
            int x = 0;
            Integer challengeId = null;
            for (ClientChallenge ch : challengeList) {
                logger.info("Checking challenge: {}", ch.getChallengeOrder());
                logger.info("{}", ch);
                challengeId=ch.getId();
                if (ch.getChallengeType().equalsIgnoreCase("adhar") &&
                    challengeInfo.getAdhar_number() != null &&
                    challengeInfo.getAdhar_number().equals(token.findByChallengeId(ch.getId()).getChallengeValue())) {
    
                    logger.info("Aadhar number matched for challenge_id: {}", ch.getId());
    
                    if (ch.getChallengeOrder() == 1) {
                        tokenVal = UUID.randomUUID().toString();
                        x++;
                        tokenInfo = token.findByChallengeId(ch.getId());
                        logger.info("Generated token for order 1: {}", tokenVal);
                        continue;
                    } else {
                        tokenInfo = token.findByChallengeId(ch.getId());
                        logger.info("Checking challenge: {}", tokenInfo.getTokenValue());
                        logger.info("Checking challenge: {}", challengeInfo.getToken_value());
                        if (challengeInfo.getToken_value() != null &&
                            challengeInfo.getToken_value().equals(tokenInfo.getTokenValue())) {
                            logger.info("Token matched successfully for challenge_id: {}", ch.getId());
                            return new TokenResponseDTO("Token matched", tokenInfo.getChallengeValue());
                        } else {
                            logger.warn("Token mismatch for challenge_id: {}", ch.getId());
                            return new TokenResponseDTO("Token mismatch", null);
                        }
                    }
                } 
            }
            if (x == 1) {
                logger.info("Updating token for challenge_id (order 2): {}",challengeId);
                token.updateData(tokenVal, challengeId);
                return new TokenResponseDTO(tokenVal, tokenInfo.getChallengeValue());
            }
    
            logger.warn("No matching Aadhar challenge found.");
            return "No matching challenge found";
    
        } catch (Exception e) {
            logger.error("Error occurred in AdharOutput: ", e);
            return "Error occurred";
        }
    }
    

    @Override
    public void loggerFunc(ResponseEntity<Object> response) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = sra.getRequest();
        String requestType = req.getMethod();
        try {
            String json = objectMapper.writeValueAsString(response.getBody());
            logger.info("Response: {}", json);
        } catch (Exception e) {
            logger.error("Error converting to JSON", e);
        }
        logger.info("This is a {} request type.", requestType);
        logger.info("URL: {}", req.getRequestURI());
    }
} 
