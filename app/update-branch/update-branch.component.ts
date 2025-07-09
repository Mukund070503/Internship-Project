import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Bank } from '../BankClass/Bank';
import { RuleService } from '../service/rule.service';

@Component({
  selector: 'app-update-branch',
  imports: [RouterLink,FormsModule],
  templateUrl: './update-branch.component.html',
  styleUrl: './update-branch.component.scss'
})
export class UpdateBranchComponent {
bankData: any[] = [];
model: Bank = new Bank(); 

constructor(private bank:RuleService, private router: Router){
}
ngOnInit(): void {
  const storedBranch = localStorage.getItem('editBranch');
  console.log('Raw localStorage data:', storedBranch);

  if (storedBranch) {
    try {
      const parsedBranch = JSON.parse(storedBranch);
      console.log('Parsed Branch:', parsedBranch);

      this.model = new Bank({
        bankCode: parsedBranch.bankCode,
        ifsc: parsedBranch.ifsc,
        branchName: parsedBranch.branchName,
        address: parsedBranch.address,
        city: parsedBranch.city,
        districtId: parsedBranch.districtId,
        micrCode: parsedBranch.micrCode,
        phone: parsedBranch.phone,
        stateCode: parsedBranch.stateCode,
        isEnabled: parsedBranch.isEnabled
      });

      console.log('Loaded Branch Model:', this.model);
    } catch (error) {
      console.error('Error parsing editBranch:', error);
    }
  } else {
    console.warn('No editBranch found in localStorage');
  }
}

onSubmit(form: NgForm) {
 console.log("Update form submitted:", form.value);

  if (form.invalid) {
    form.control.markAllAsTouched();
    return;
  }

  this.bank.updateBranch(this.model).subscribe(
    (response: any) => {
      console.log('Update response:', response);
      alert("Branch updated successfully");
      localStorage.removeItem('editBranch');
      this.router.navigate(['/branches']);
    },
    error => {
      console.error('Update error:', error);
      alert("Error updating branch");
    }
  );

}
}
