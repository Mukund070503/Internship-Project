import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { RuleService } from '../service/rule.service';
import { Bank } from '../BankClass/Bank';

@Component({
  selector: 'app-update-bank',
  imports: [RouterLink,FormsModule],
  templateUrl: './update-bank.component.html',
  styleUrl: './update-bank.component.scss'
})
export class UpdateBankComponent {
bankData: any[] = [];
model: Bank = new Bank(); 
ngOnInit(): void {
    const storedBank = localStorage.getItem('editBank');
    console.log('Raw localStorage data:', storedBank);

    if (storedBank) {
      try {
        const parsedBank = JSON.parse(storedBank);
        console.log('Parsed Bank:', parsedBank);

        this.model = new Bank({
        bankCode: parsedBank.bankCode,
        name: parsedBank.name,
        defaultIfsc: parsedBank.defaultIfsc,
        isEnabled: parsedBank.isEnabled,
        isImpsEnabled: parsedBank.isImpsEnabled,
        isLoadCashEnabled: parsedBank.isLoadCashEnabled,
        isUpiEnabled: parsedBank.isUpiEnabled,
        iin: parsedBank.iin,
        bankIconUrl: parsedBank.bankIconUrl
        });


        console.log('Loaded Model:', this.model);
      } catch (error) {
        console.error('Error parsing editBank:', error);
      }
    } else {
      console.warn('No editBank found in localStorage');
    }
  }
constructor(private bank:RuleService, private router: Router){
}
onSubmit(form: NgForm) {
  console.log("Update form submitted:", form.value);

  if (form.invalid) {
    form.control.markAllAsTouched();
    return;
  }

  this.bank.updateBank(this.model).subscribe(
    (response: any) => {
      console.log('Update response:', response);
      alert("Bank updated successfully");
      localStorage.removeItem('editBank');
      this.router.navigate(['/bank']);
    },
    error => {
      console.error('Update error:', error);
      alert("Error updating bank");
    }
  );
}

}