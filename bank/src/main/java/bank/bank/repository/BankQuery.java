package bank.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bank.bank.entities.Bank;
import bank.bank.entities.BankDTO;
import jakarta.transaction.Transactional;

public interface BankQuery extends JpaRepository <Bank, String>{

    //@Query(value = "Select * FROM bank_details", nativeQuery = true)
    //public List<Bank> getData();

    @Modifying
    @Transactional
    @Query(value ="DELETE FROM bank_details WHERE DEFAULT_IFSC =:DEFAULT_IFSC" ,nativeQuery = true)
    public void deleteBank(String DEFAULT_IFSC);   
    
    @Query(value = "SELECT * FROM bank_details WHERE BANK_CODE = :bankCode", nativeQuery = true)
    List<Bank> findByBankCode(String bankCode);

@Modifying
@Transactional
@Query(value = "INSERT INTO bank_details (BANK_CODE, NAME, DEFAULT_IFSC, IS_ENABLED, IS_IMPS_ENABLED, IS_LOAD_CASH_ENABLED, IS_UPI_ENABLED, IIN, BANK_ICON_URL) " +
        "VALUES (:bankCode, :name, :defaultIfsc, :isEnabled, :isImpsEnabled, :isLoadCashEnabled, :isUpiEnabled, :iin, :bankIconUrl)", nativeQuery = true)
void insertBank(
    @Param("bankCode") String bankCode,
    @Param("name") String name,
    @Param("defaultIfsc") String defaultIfsc,
    @Param("isEnabled") Boolean isEnabled,
    @Param("isImpsEnabled") Boolean isImpsEnabled,
    @Param("isLoadCashEnabled") Boolean isLoadCashEnabled,
    @Param("isUpiEnabled") Boolean isUpiEnabled,
    @Param("iin") String iin,
    @Param("bankIconUrl") String bankIconUrl
);



    @Modifying
    @Transactional
    @Query(value = " UPDATE bank_details SET  NAME = :#{#dto.name}, DEFAULT_IFSC = :#{#dto.defaultIfsc}, IS_ENABLED = :#{#dto.isEnabled}, IS_IMPS_ENABLED = :#{#dto.isImpsEnabled}, IS_LOAD_CASH_ENABLED = :#{#dto.isLoadCashEnabled}, IS_UPI_ENABLED = :#{#dto.isUpiEnabled}, IIN = :#{#dto.iin}, BANK_ICON_URL = :#{#dto.bankIconUrl} WHERE DEFAULT_IFSC = :#{#dto.defaultIfsc} ", nativeQuery = true)
    int updateBank(@Param("dto") BankDTO dto);

}
