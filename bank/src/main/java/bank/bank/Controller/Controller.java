package bank.bank.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.bank.ServicePackage.ServiceImpl;
import bank.bank.entities.BankDTO;
import bank.bank.entities.BranchDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private ServiceImpl bank;

    @GetMapping("banks")
    public List<BankDTO> allBanks(){
        return bank.allBanks();
    }

    @GetMapping("branches")
    public List<BranchDTO> allBranches(){
        return bank.allBranches();
    }

    @PostMapping("/removeBank")
    public ResponseEntity<Object> deleteBank(@RequestBody BankDTO bankinfodto){
        ResponseEntity<Object> response = bank.deleteBank(bankinfodto);  
        bank.loggerFunc(response);
        return response;
    }

    @PostMapping("/removeBranch")
    public ResponseEntity<Object> deleteBranch(@RequestBody BranchDTO branchinfodto){
        ResponseEntity<Object> response = bank.deleteBranch(branchinfodto);  
        bank.loggerFunc(response);
        return response;
    }

    @PostMapping("banksByBankCode")
    public List<BankDTO> banksByBankCode(@RequestBody String BankCode){
        return bank.allBanksByBankCode(BankCode);
    }

    @PostMapping("branchesByIfsc")
    public List<BranchDTO> branchesByIfsc(@RequestBody String Ifsc){
        return bank.allBranchesByIfsc(Ifsc);
    }

    @PostMapping("insertBank")
    public String insertBank(@RequestBody BankDTO bankinfoDTO){
        return bank.insertBank(bankinfoDTO);
    }

    @PostMapping("insertBranch")
    public String insertBranch(@RequestBody BranchDTO branchinfoDTO) {
        return bank.insertBranch(branchinfoDTO);
    }

    @PostMapping("updateBank")
    public String updateBank(@RequestBody BankDTO bankinfoDTO){
        return bank.updateBank(bankinfoDTO);
    }

    @PostMapping("updateBranch")
    public String updateBranch(@RequestBody BranchDTO branchinfoDTO) {
        return bank.updateBranch(branchinfoDTO);
    }
}


