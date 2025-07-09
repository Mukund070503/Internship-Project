package com.mpin.mpin_response.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import jakarta.persistence.*;
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Entity
@Table(name = "client_details")
public class TeamInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "team_dl")
    private String teamDl;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "service_id")
    private String serviceId;

    @Column(name = "description")
    private String description;

    @Column(name = "Average_Traffic")
    private String averageTraffic;

    @Column(name = "Peak_Traffic")
    private String peakTraffic;

    @Column(name = "Peak_Traffic_Hrs")
    private String peakTrafficHrs;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }

    public String getTeamDl() { return teamDl; }
    public void setTeamDl(String teamDl) { this.teamDl = teamDl; }

    public String getApplicationName() { return applicationName; }
    public void setApplicationName(String applicationName) { this.applicationName = applicationName; }

    public String getServiceId() { return serviceId; }
    public void setServiceId(String serviceId) { this.serviceId = serviceId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAverageTraffic() { return averageTraffic; }
    public void setAverageTraffic(String averageTraffic) { this.averageTraffic = averageTraffic; }

    public String getPeakTraffic() { return peakTraffic; }
    public void setPeakTraffic(String peakTraffic) { this.peakTraffic = peakTraffic; }

    public String getPeakTrafficHrs() { return peakTrafficHrs; }
    public void setPeakTrafficHrs(String peakTrafficHrs) { this.peakTrafficHrs = peakTrafficHrs; }
}
