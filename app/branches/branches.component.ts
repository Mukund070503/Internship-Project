import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { RuleService } from '../service/rule.service';
import {MatButtonModule} from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule, NgForm } from '@angular/forms';
import { Bank } from '../BankClass/Bank';

@Component({
  selector: 'app-branches',
  imports: [CommonModule,RouterLink,MatButtonModule,MatIconModule,FormsModule],
  templateUrl: './branches.component.html',
  styleUrl: './branches.component.scss'
})
export class BranchesComponent {
branchesData: any[] = [];
model: Bank = new Bank(); 
data:any;
constructor(private bank:RuleService, private router: Router){
}
ngOnInit(): void { 
  this.bank.allBranches().subscribe(
    (response:any) => {
      console.log(response);
      this.branchesData = response;
    },
    error => {
      console.log(error);
    }
  );
}
setEditBank(branch: any): void {
  localStorage.setItem('editBranch', JSON.stringify(branch));
  console.log('Stored editBranch:', branch);
}
deleteBranch(branch:any){
  this.bank.deleteBranch(branch).subscribe(
    (response:any) => {
      console.log(response);
      this.data = response.data;
      alert("Branch deleted successfully");
      window.location.reload();
    },
    error => {
      console.log(error);
      alert("Error deleting branch");
    }
  );
}
onSubmit(form: NgForm) {
  console.log("Submit called", form.value);
  if (form.invalid) {
    form.control.markAllAsTouched();
    return;
  }

  this.bank.allBranchesByIfsc(form.value.IFSC).subscribe(
    (response: any) => {
      console.log("response:",response);
      this.branchesData = response;
      alert("Data fetched successfully");
      localStorage.setItem('allBranchesByIfsc', JSON.stringify(this.branchesData)); 
      console.log('Stored Branches:', this.branchesData);
      this.router.navigate(['/all-branches-by-ifsc']);
    },
    error => {
      console.log(error);
      alert("Error fetching data");
    }
  );

  console.log(form.value);
}
}
