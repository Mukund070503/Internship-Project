package com.authhub.authhub.servicePackage;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.authhub.authhub.entities.ClientChallengeDTO;
import com.authhub.authhub.entities.ClientDTO;

public interface ServiceInterface {
        public List<ClientDTO> allClients();
        public Object PanOutput(ClientChallengeDTO challengeInfo);
        public Object AdharOutput(ClientChallengeDTO challengeInfo);
        public void loggerFunc(ResponseEntity<Object> response);
}
