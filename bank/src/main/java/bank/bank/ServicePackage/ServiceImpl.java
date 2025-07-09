package bank.bank.ServicePackage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import bank.bank.Controller.Controller;
import bank.bank.entities.Bank;
import bank.bank.entities.BankDTO;
import bank.bank.entities.Branch;
import bank.bank.entities.BranchDTO;
import bank.bank.repository.BankQuery;
import bank.bank.repository.BranchQuery;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class ServiceImpl implements ServiceInterface{
private static final Logger logger = (Logger) LoggerFactory.getLogger(Controller.class);
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private BankQuery bank;
    @Autowired
    private BranchQuery branch;

    @Override
public List<BankDTO> allBanks() {
    List<Bank> bankList = bank.findAll();
    List<BankDTO> dtoList = new ArrayList<>();

    for (Bank b : bankList) {
        BankDTO dto = new BankDTO();
        dto.setBankCode(b.getBankCode());
        dto.setName(b.getName());
        dto.setDefaultIfsc(b.getDefaultIfsc());
        dto.setIsEnabled(b.getIsEnabled());
        dto.setIsImpsEnabled(b.getIsImpsEnabled());
        dto.setIsLoadCashEnabled(b.getIsLoadCashEnabled());
        dto.setIsUpiEnabled(b.getIsUpiEnabled());
        dto.setIin(b.getIin());
        dto.setBankIconUrl(b.getBankIconUrl());
        dtoList.add(dto);
    }

    return dtoList;
}


@Override
public List<BranchDTO> allBranches() {
    List<Branch> branchList = branch.findAll(); 
    List<BranchDTO> dtoList = new ArrayList<>();

    for (Branch b : branchList) {
        BranchDTO dto = new BranchDTO();
        dto.setIfsc(b.getIfsc());
        dto.setAddress(b.getAddress());
        dto.setBankCode(b.getBank().getBankCode()); 
        dto.setBranchName(b.getBranchName());
        dto.setCity(b.getCity());
        dto.setDistrictId(b.getDistrictId());
        dto.setMicrCode(b.getMicrCode());
        dto.setPhone(b.getPhone());
        dto.setStateCode(b.getStateCode());
        dto.setIsEnabled(b.getIsEnabled());

        dtoList.add(dto);
    }

    return dtoList;
}

@Override
public ResponseEntity<Object> deleteBank(BankDTO bankinfodto) {
    String bankCode = bankinfodto.getBankCode();

    List<Branch> branches = branch.findByBankCode(bankCode);

    if (branches != null && !branches.isEmpty()) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("meta", "Cannot delete bank: Branches exist for this bank.");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    bank.deleteBank(bankinfodto.getDefaultIfsc());

    Map<String, Object> response = new LinkedHashMap<>();
    response.put("meta", "Bank Deleted Successfully");
    return new ResponseEntity<>(response, HttpStatus.OK);
}

    @Override
    public ResponseEntity<Object> deleteBranch(BranchDTO branchinfodto) {

        branch.deleteBranch(branchinfodto.getIfsc());

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("meta","Branch Deleted Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public List<BankDTO> allBanksByBankCode(String bankCode){
    List<Bank> bankList = bank.findByBankCode(bankCode);
    List<BankDTO> dtoList = new ArrayList<>();

    for (Bank b : bankList) {
        BankDTO dto = new BankDTO();
        dto.setBankCode(b.getBankCode());
        dto.setName(b.getName());
        dto.setDefaultIfsc(b.getDefaultIfsc());
        dto.setIsEnabled(b.getIsEnabled());
        dto.setIsImpsEnabled(b.getIsImpsEnabled());
        dto.setIsLoadCashEnabled(b.getIsLoadCashEnabled());
        dto.setIsUpiEnabled(b.getIsUpiEnabled());
        dto.setIin(b.getIin());
        dto.setBankIconUrl(b.getBankIconUrl());
        dtoList.add(dto);
    }

    return dtoList;
}

@Override
public List<BranchDTO> allBranchesByIfsc(String Ifsc) {
    List<Branch> branchList = branch.findByifsc(Ifsc); 
    List<BranchDTO> dtoList = new ArrayList<>();

    for (Branch b : branchList) {
        BranchDTO dto = new BranchDTO();
        dto.setIfsc(b.getIfsc());
        dto.setAddress(b.getAddress());
        dto.setBankCode(b.getBank().getBankCode()); 
        dto.setBranchName(b.getBranchName());
        dto.setCity(b.getCity());
        dto.setDistrictId(b.getDistrictId());
        dto.setMicrCode(b.getMicrCode());
        dto.setPhone(b.getPhone());
        dto.setStateCode(b.getStateCode());
        dto.setIsEnabled(b.getIsEnabled());

        dtoList.add(dto);
    }

    return dtoList;
}
@Override
public String insertBank(BankDTO dto) {
    bank.insertBank(
        dto.getBankCode(),
        dto.getName(),
        dto.getDefaultIfsc(),
        dto.getIsEnabled(),
        dto.getIsImpsEnabled(),
        dto.getIsLoadCashEnabled(),
        dto.getIsUpiEnabled(),
        dto.getIin(),
        dto.getBankIconUrl()
    );
    return "Successfully added bank.";
}



 @Override
public String insertBranch(BranchDTO dto) {
    int rowsInserted = branch.insertBranch(
        dto.getIfsc(),
        dto.getAddress(),
        dto.getBankCode(),
        dto.getBranchName(),
        dto.getCity(),
        dto.getDistrictId(),
        dto.getMicrCode(),
        dto.getPhone(),
        dto.getStateCode(),
        dto.getIsEnabled()
    );
    return rowsInserted > 0 ? "Successfully added branch." : "Branch insert failed.";
}

@Override
public String updateBank(BankDTO bankinfoDTO) {
    int rowsUpdated = bank.updateBank(bankinfoDTO);
    if (rowsUpdated > 0) {
        return "Successfully updated bank.";
    } else {
        return "Bank update failed. Bank code may not exist.";
    }
}

    @Override
public String updateBranch(BranchDTO branchinfoDTO) {
    int rowsUpdated = branch.updateBranch(branchinfoDTO);
    if (rowsUpdated > 0) {
        return "Successfully updated branch.";
    } else {
        return "Branch update failed. IFSC may not exist.";
    }
}

@Override
    public void loggerFunc(ResponseEntity<Object> response) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = sra.getRequest();
        String requestType = req.getMethod();
        try {
            String json = objectMapper.writeValueAsString(response.getBody());
            logger.info("Response: {}", json);
        } catch (Exception e) {
            logger.error("Error converting to JSON", e);
        }
        logger.info("This is a {} request type.", requestType);
        logger.info("URL: {}", req.getRequestURI());
    }
}
