package bank.bank.entities;

    import jakarta.persistence.*;
    
    @Entity
    @Table(name = "bank_details")
    public class Bank {
    
        @Id
        @Column(name = "BANK_CODE", length = 20)
        private String bankCode;
    
        @Column(name = "NAME", length = 256, nullable = false)
        private String name;
    
        @Column(name = "DEFAULT_IFSC", length = 50)
        private String defaultIfsc;
    
        @Column(name = "IS_ENABLED")
        private Boolean isEnabled;
    
        @Column(name = "IS_IMPS_ENABLED", nullable = false)
        private Boolean isImpsEnabled;
    
        @Column(name = "IS_LOAD_CASH_ENABLED")
        private Boolean isLoadCashEnabled;
    
        @Column(name = "IS_UPI_ENABLED", nullable = false)
        private Boolean isUpiEnabled;
    
        @Column(name = "IIN", length = 256)
        private String iin;
    
        @Column(name = "BANK_ICON_URL", length = 500)
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

