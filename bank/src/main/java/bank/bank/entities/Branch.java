package bank.bank.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "branch_details")

public class Branch {

    @Id
    @Column(name = "IFSC", length = 50)
    private String ifsc;

    @Column(name = "ADDRESS", length = 500)
    private String address;

    @ManyToOne
    @JoinColumn(name = "BANK_CODE", nullable = false)
    private Bank bank;

    @Column(name = "BRANCH_NAME", length = 256, nullable = false)
    private String branchName;

    @Column(name = "CITY", length = 256)
    private String city;

    @Column(name = "DISTRICT_ID", nullable = false)
    private Integer districtId;

    @Column(name = "MICR_CODE", length = 9)
    private String micrCode;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @Column(name = "STATE_CODE", length = 20, nullable = false)
    private String stateCode;

    @Column(name = "IS_ENABLED")
    private Boolean isEnabled;

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getMicrCode() {
        return micrCode;
    }

    public void setMicrCode(String micrCode) {
        this.micrCode = micrCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
}