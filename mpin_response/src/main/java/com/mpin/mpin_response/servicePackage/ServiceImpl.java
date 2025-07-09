package com.mpin.mpin_response.servicePackage;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mpin.mpin_response.controllerPackage.BaseController;
import com.mpin.mpin_response.controllerPackage.Controller;
import com.mpin.mpin_response.entities.TeamInfo;
import com.mpin.mpin_response.entities.TeamInfoDTO;
import com.mpin.mpin_response.repository.StatusResponse;

import ch.qos.logback.classic.Logger;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ServiceImpl implements ServiceInterface {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Controller.class);

    @Autowired
    private BaseController baseController;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StatusResponse queryResponse;

    @Override
    public ResponseEntity<Object> getData() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Map<String, Object>> teamList = new ArrayList<>();

        List<TeamInfo> teamData = queryResponse.getData();
        for (TeamInfo row : teamData) {
            Map<String, Object> teamMap = new LinkedHashMap<>();
            teamMap.put("id", row.getId());
            teamMap.put("team_name", row.getTeamName());
            teamMap.put("team_dl", row.getTeamDl());
            teamMap.put("application_name", row.getApplicationName());
            teamMap.put("service_id", row.getServiceId());
            teamMap.put("description", row.getDescription());
            teamMap.put("Average_Traffic", row.getAverageTraffic());
            teamMap.put("Peak_Traffic", row.getPeakTraffic());
            teamMap.put("Peak_Traffic_Hrs", row.getPeakTrafficHrs());
            teamList.add(teamMap);
        }

        response.put("meta", baseController.Success());
        response.put("data", Map.of("TeamList", teamList));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
 
    @Override
    public ResponseEntity<Object> getDataBySId(String sId) {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Map<String, Object>> teamList = new ArrayList<>();

        List<TeamInfo> teamData = queryResponse.getDataBySId(sId);
        for (TeamInfo row : teamData) {
            Map<String, Object> teamMap = new LinkedHashMap<>();
            teamMap.put("id", row.getId());
            teamMap.put("team_name", row.getTeamName());
            teamMap.put("team_dl", row.getTeamDl());
            teamMap.put("application_name", row.getApplicationName());
            teamMap.put("service_id", row.getServiceId());
            teamMap.put("description", row.getDescription());
            teamMap.put("Average_Traffic", row.getAverageTraffic());
            teamMap.put("Peak_Traffic", row.getPeakTraffic());
            teamMap.put("Peak_Traffic_Hrs", row.getPeakTrafficHrs());
            teamList.add(teamMap);
        }

        response.put("meta", baseController.Success());
        response.put("data", Map.of("TeamList", teamList));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> getDataById(Integer Id) {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Map<String, Object>> teamList = new ArrayList<>();

        List<TeamInfo> teamData = queryResponse.getDataById(Id);
        for (TeamInfo row : teamData) {
            Map<String, Object> teamMap = new LinkedHashMap<>();
            teamMap.put("id", row.getId());
            teamMap.put("team_name", row.getTeamName());
            teamMap.put("team_dl", row.getTeamDl());
            teamMap.put("application_name", row.getApplicationName());
            teamMap.put("service_id", row.getServiceId());
            teamMap.put("description", row.getDescription());
            teamMap.put("Average_Traffic", row.getAverageTraffic());
            teamMap.put("Peak_Traffic", row.getPeakTraffic());
            teamMap.put("Peak_Traffic_Hrs", row.getPeakTrafficHrs());
            teamList.add(teamMap);
        }

        response.put("meta", baseController.Success());
        response.put("data", Map.of("TeamList", teamList));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Object> insertData(TeamInfoDTO teaminfodto) {
        if (queryResponse.teamIdExists(teaminfodto.getId()) == 1L) {
            return new ResponseEntity<>(baseController.TeamExists(), HttpStatus.OK);
        }

        queryResponse.dataInserted(teaminfodto);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("meta", baseController.SuccessMessage("Team inserted successfully"));
        response.put("data", Map.of("isSuccessful", true));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> updateData(TeamInfoDTO teaminfodto) {
        if (queryResponse.teamIdExists(teaminfodto.getId()) == 0L) {
            return new ResponseEntity<>(baseController.TeamNotFound("Team doesn’t exist"), HttpStatus.OK);
        }

        queryResponse.updateData(teaminfodto);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("meta", baseController.SuccessMessage("Successfully Updated"));
        response.put("data", Map.of("isSuccessful", true));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteData(TeamInfoDTO teaminfodto) {
        if (queryResponse.teamIdExists(teaminfodto.getId()) == 0L) {
            return new ResponseEntity<>(baseController.TeamNotFound("Team already doesn’t exist"), HttpStatus.OK);
        }

        queryResponse.deleteRule(teaminfodto.getId());

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("meta", baseController.SuccessMessage("Team Deleted Successfully"));
        return new ResponseEntity<>(response, HttpStatus.OK);
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