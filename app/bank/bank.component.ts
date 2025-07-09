import { Component } from '@angular/core';
import { RouterLink ,Router} from '@angular/router';
import { RuleService } from '../service/rule.service';
import { CommonModule } from '@angular/common';
import {MatButtonModule} from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule, NgForm } from '@angular/forms';
import { Bank } from '../BankClass/Bank';
@Component({
  selector: 'app-bank',
  imports: [CommonModule,RouterLink,MatButtonModule,MatIconModule,FormsModule],
  templateUrl: './bank.component.html',
  styleUrl: './bank.component.scss'
})
export class BankComponent {
banksData: any[] = [];
model: Bank = new Bank(); 
data:any;
constructor(private bank:RuleService, private router: Router){
}
ngOnInit(): void { 
  this.bank.allBanks().subscribe(
    (response:any) => {
      console.log(response);
      this.banksData = response;
    },
    error => {
      console.log(error);
    }
  );

}
setEditBank(bank: any): void {
  localStorage.setItem('editBank', JSON.stringify(bank));
  console.log('Stored editBank:', bank);
}
deleteBank(bank:any){
  this.bank.deleteBank(bank).subscribe(
    (response:any) => {
      console.log(response);
      this.data = response.data;
      alert("Bank deleted successfully");
      window.location.reload();
    },
    error => {
      console.log(error);
      alert("Error deleting branch check if branches persist.");
    }
  );
}
onSubmit(form: NgForm) {
  console.log("Submit called", form.value);
  if (form.invalid) {
    form.control.markAllAsTouched();
    return;
  }

  this.bank.allBanksByBankCode(form.value.BANK_CODE).subscribe(
    (response: any) => {
      console.log(response);
      this.banksData = response;
      alert("Data fetched successfully");
      localStorage.setItem('allBanksByBankCode', JSON.stringify(this.banksData)); 
      console.log('Stored Banks:', this.banksData);
      this.router.navigate(['/all-banks-by-bank-code']);
    },
    error => {
      console.log(error);
      alert("Error fetching data");
    }
  );

  console.log(form.value);
}
}
