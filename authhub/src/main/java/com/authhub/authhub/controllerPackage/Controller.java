package com.authhub.authhub.controllerPackage;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.authhub.authhub.entities.ClientChallengeDTO;
import com.authhub.authhub.entities.ClientDTO;
import com.authhub.authhub.servicePackage.ServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    private ServiceImpl challenge;
    @GetMapping("clients")
    public List<ClientDTO> allClients() {
        return challenge.allClients();
    }
    
    @PostMapping("/auth/pan")
    public Object PanApi(@RequestBody ClientChallengeDTO challengeInfo) {
        Object response = challenge.PanOutput(challengeInfo);
        challenge.loggerFunc(ResponseEntity.ok(response)); 
        return response;
    }
    @PostMapping("/auth/Adhar")
    public Object AdharApi(@RequestBody ClientChallengeDTO challengeInfo) {
        Object response = challenge.AdharOutput(challengeInfo);
        challenge.loggerFunc(ResponseEntity.ok(response));  
        return response;
    }
}
