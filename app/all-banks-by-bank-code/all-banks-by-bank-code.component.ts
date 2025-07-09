import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { RuleService } from '../service/rule.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-all-banks-by-bank-code',
  imports: [CommonModule,MatButtonModule,MatIconModule,RouterLink],
  templateUrl: './all-banks-by-bank-code.component.html',
  styleUrl: './all-banks-by-bank-code.component.scss'
})
export class AllBanksByBankCodeComponent {
banksData:any[]=[];
data:any;
constructor(private bank: RuleService,private router: Router) {}

  ngOnInit(): void {
    try {
      const storedBanks = localStorage.getItem('allBanksByBankCode');
      console.log('Raw localStorage data:', storedBanks);
      if (storedBanks) {
        this.banksData = JSON.parse(storedBanks);
        console.log('Parsed banksData:', this.banksData);
      } else {
        console.warn('No banksByBankCode data found in localStorage.');
      }
    } catch (error) {
      console.error('Error parsing localStorage data:', error);
    }
  }
  deleteBank(bank:any){
    console.log('Bank being deleted:', bank);
    this.bank.deleteBank(bank).subscribe(
      (response:any) => {
        console.log(response);
        this.data = response.data;
        alert("Bank deleted successfully");
        this.router.navigate(['/bank']);
      },
      error => {
        console.log(error);
        alert("Error deleting branch check if branches persist.");
      }
    );
  }
}
