package com.authhub.authhub.entities;

public class ClientDTO {

    private Integer id;
    private String clientId;
    private String clientName;
    private String serviceId;

    // Getters
    public Integer getId() {
        return id;
    }
    public String getClientId() {
        return clientId;
    }
    public String getClientName() {
        return clientName;
    }
    public String getServiceId() {
        return serviceId;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
