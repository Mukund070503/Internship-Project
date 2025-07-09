package bank.bank.entities;

public class BankDTO {
    private String bankCode;
    private String name;
    private String defaultIfsc;
    private Boolean isEnabled;
    private Boolean isImpsEnabled;
    private Boolean isLoadCashEnabled;
    private Boolean isUpiEnabled;
    private String iin;
    private String bankIconUrl;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultIfsc() {
        return defaultIfsc;
    }

    public void setDefaultIfsc(String defaultIfsc) {
        this.defaultIfsc = defaultIfsc;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Boolean getIsImpsEnabled() {
        return isImpsEnabled;
    }

    public void setIsImpsEnabled(Boolean isImpsEnabled) {
        this.isImpsEnabled = isImpsEnabled;
    }

    public Boolean getIsLoadCashEnabled() {
        return isLoadCashEnabled;
    }

    public void setIsLoadCashEnabled(Boolean isLoadCashEnabled) {
        this.isLoadCashEnabled = isLoadCashEnabled;
    }

    public Boolean getIsUpiEnabled() {
        return isUpiEnabled;
    }

    public void setIsUpiEnabled(Boolean isUpiEnabled) {
        this.isUpiEnabled = isUpiEnabled;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getBankIconUrl() {
        return bankIconUrl;
    }

    public void setBankIconUrl(String bankIconUrl) {
        this.bankIconUrl = bankIconUrl;
    }
}
