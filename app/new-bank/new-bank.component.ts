import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Bank } from '../BankClass/Bank';
import { RuleService } from '../service/rule.service';

@Component({
  selector: 'app-new-bank',
  imports: [RouterLink,FormsModule],
  templateUrl: './new-bank.component.html',
  styleUrl: './new-bank.component.scss'
})
export class NewBankComponent {
model: Bank = new Bank();
banksData: any[] = [];
constructor(private bank:RuleService, private router: Router){} 
onSubmit(form:NgForm){
    if(form.invalid){
    form.control.markAllAsTouched();
    return;
  }
  this.bank.insertBank(this.model).subscribe(
    (response:any) => {
      console.log("Response: ",response);
      this.banksData = response.data;
      alert("Bank inserted successfully");
      this.router.navigate(['/bank']);
    },
    error => {
      console.log(error);
      alert("Error inserting Bank");
      window.location.reload();
    }
  );
  console.log(form.value);
}
}
