package bank.bank.ServicePackage;
import java.util.List;

import org.springframework.http.ResponseEntity;

import bank.bank.entities.BankDTO;
import bank.bank.entities.BranchDTO;

public interface ServiceInterface {
    public List<BankDTO> allBanks();
    public List<BranchDTO> allBranches();
    ResponseEntity<Object> deleteBank(BankDTO bankinfoDTO);
    ResponseEntity<Object> deleteBranch(BranchDTO branchinfoDTO);
    public List<BankDTO> allBanksByBankCode(String BankCode);
    public List<BranchDTO> allBranchesByIfsc(String Ifsc);
    public void loggerFunc(ResponseEntity<Object> response);
    public String insertBank(BankDTO bankinfoDTO);
    public String insertBranch(BranchDTO branchinfoDTO);
    public String updateBank(BankDTO bankinfoDTO);
    public String updateBranch(BranchDTO branchinfoDTO);
}
