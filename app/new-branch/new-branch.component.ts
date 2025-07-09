import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Bank } from '../BankClass/Bank';
import { RuleService } from '../service/rule.service';

@Component({
  selector: 'app-new-branch',
  imports: [RouterLink,FormsModule],
  templateUrl: './new-branch.component.html',
  styleUrl: './new-branch.component.scss'
})
export class NewBranchComponent {
banksData: any[] = [];
model: Bank = new Bank(); 

constructor(private branch:RuleService, private router: Router){
}
onSubmit(form:NgForm){
  this.branch.insertBranch(this.model).subscribe(
    (response:any) => {
      console.log("Response: ",response);
      this.banksData = response.data;
      alert("Branch inserted successfully");
      this.router.navigate(['/branches']);
    },
    error => {
      console.log(error);
      alert("Error inserting Branch");
      window.location.reload();
    }
  );
  console.log(form.value);
}
}
