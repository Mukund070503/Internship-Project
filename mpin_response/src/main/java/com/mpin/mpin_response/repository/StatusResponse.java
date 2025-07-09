package com.mpin.mpin_response.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mpin.mpin_response.entities.TeamInfo;
import com.mpin.mpin_response.entities.TeamInfoDTO;

import jakarta.transaction.Transactional;

@Repository
public interface StatusResponse extends JpaRepository <TeamInfo, Integer>{

    @Query(value = "Select * FROM client_details", nativeQuery = true)
    public List<TeamInfo> getData();

    @Query(value = "Select * FROM client_details where service_id=:sId", nativeQuery = true)
    public List<TeamInfo> getDataBySId(String sId);

    @Query(value = "Select * FROM client_details where id=:id", nativeQuery = true)
    public List<TeamInfo> getDataById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO client_details (team_name, team_dl, application_name, service_id, description, Average_Traffic, Peak_Traffic, Peak_Traffic_Hrs) VALUES (:#{#dto.teamName}, :#{#dto.teamDl}, :#{#dto.applicationName}, :#{#dto.serviceId}, :#{#dto.description}, :#{#dto.averageTraffic}, :#{#dto.peakTraffic}, :#{#dto.peakTrafficHrs})", nativeQuery = true)
    void dataInserted(@Param("dto") TeamInfoDTO dto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE client_details SET team_name = :#{#dto.teamName}, team_dl = :#{#dto.teamDl}, application_name = :#{#dto.applicationName}, service_id = :#{#dto.serviceId}, description = :#{#dto.description}, Average_Traffic = :#{#dto.averageTraffic}, Peak_Traffic = :#{#dto.peakTraffic}, Peak_Traffic_Hrs = :#{#dto.peakTrafficHrs} WHERE id = :#{#dto.id}", nativeQuery = true)
    public void updateData(@Param("dto") TeamInfoDTO dto);

    @Modifying
    @Transactional
    @Query(value ="DELETE FROM client_details WHERE id =:id" ,nativeQuery = true)
    public void deleteRule(Integer id);

    @Query(value = "SELECT COUNT(id) FROM client_details WHERE id = :id", nativeQuery = true)
    long teamExists(Integer id);
    
    @Query(value = "SELECT COUNT(id) FROM client_details WHERE  id= :id", nativeQuery = true)
    public long teamIdExists(Integer id);

}
