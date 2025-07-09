package com.mpin.mpin_response.entities;

public class TeamInfoDTO {
    private Integer id;
    private String teamName;
    private String teamDl;
    private String applicationName;
    private String serviceId;
    private String description;
    private String averageTraffic;
    private String peakTraffic;
    private String peakTrafficHrs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDl() {
        return teamDl;
    }

    public void setTeamDl(String teamDl) {
        this.teamDl = teamDl;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAverageTraffic() {
        return averageTraffic;
    }

    public void setAverageTraffic(String averageTraffic) {
        this.averageTraffic = averageTraffic;
    }

    public String getPeakTraffic() {
        return peakTraffic;
    }

    public void setPeakTraffic(String peakTraffic) {
        this.peakTraffic = peakTraffic;
    }

    public String getPeakTrafficHrs() {
        return peakTrafficHrs;
    }

    public void setPeakTrafficHrs(String peakTrafficHrs) {
        this.peakTrafficHrs = peakTrafficHrs;
    }
}