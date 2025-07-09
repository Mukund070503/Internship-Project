package bank.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bank.bank.entities.Branch;
import bank.bank.entities.BranchDTO;
import jakarta.transaction.Transactional;

public interface BranchQuery extends JpaRepository <Branch, String>{
// @Query(value="SELECT * FROM branch_details",nativeQuery = true)
//    List<Branch> getData();
@Modifying
    @Transactional
    @Query(value ="DELETE FROM branch_details WHERE IFSC =:IFSC" ,nativeQuery = true)
    public void deleteBranch(String IFSC);    

    @Query(value = "SELECT * FROM branch_details WHERE IFSC = :ifsc", nativeQuery = true)
    List<Branch> findByifsc(String ifsc);

    @Query(value = "SELECT * FROM branch_details WHERE BANK_CODE= :bankCode", nativeQuery = true)
    List<Branch> findByBankCode(String bankCode);

    @Modifying
@Transactional
@Query(value = "INSERT INTO branch_details (IFSC, ADDRESS, BANK_CODE, BRANCH_NAME, CITY, DISTRICT_ID, MICR_CODE, PHONE, STATE_CODE, IS_ENABLED) " +
        "VALUES (:ifsc, :address, :bankCode, :branchName, :city, :districtId, :micrCode, :phone, :stateCode, :isEnabled)", nativeQuery = true)
int insertBranch(
    @Param("ifsc") String ifsc,
    @Param("address") String address,
    @Param("bankCode") String bankCode,
    @Param("branchName") String branchName,
    @Param("city") String city,
    @Param("districtId") Integer districtId,
    @Param("micrCode") String micrCode,
    @Param("phone") String phone,
    @Param("stateCode") String stateCode,
    @Param("isEnabled") Boolean isEnabled
);

    @Modifying
    @Transactional
    @Query(value = " UPDATE branch_details SET ADDRESS = :#{#dto.address}, BANK_CODE = :#{#dto.bankCode}, BRANCH_NAME = :#{#dto.branchName}, CITY = :#{#dto.city}, DISTRICT_ID = :#{#dto.districtId}, MICR_CODE = :#{#dto.micrCode}, PHONE = :#{#dto.phone}, STATE_CODE = :#{#dto.stateCode},IS_ENABLED = :#{#dto.isEnabled} WHERE IFSC = :#{#dto.ifsc}", nativeQuery = true)
    int updateBranch(@Param("dto") BranchDTO dto);

    
}
