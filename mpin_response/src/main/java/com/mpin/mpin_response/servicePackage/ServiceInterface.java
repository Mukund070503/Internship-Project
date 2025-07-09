package com.mpin.mpin_response.servicePackage;

import org.springframework.http.ResponseEntity;

import com.mpin.mpin_response.entities.TeamInfoDTO;

public interface ServiceInterface {
    ResponseEntity<Object> getData();
    public ResponseEntity<Object> getDataBySId(String sId);
    public ResponseEntity<Object> getDataById(Integer id);
    ResponseEntity<Object> insertData(TeamInfoDTO teaminfodto);
    ResponseEntity<Object> updateData(TeamInfoDTO teaminfodto);
    ResponseEntity<Object> deleteData(TeamInfoDTO teaminfodto);
    public void loggerFunc(ResponseEntity<Object> response);
}
