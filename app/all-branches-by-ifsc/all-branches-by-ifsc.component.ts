import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { Router, RouterLink } from '@angular/router';
import { RuleService } from '../service/rule.service';

@Component({
  selector: 'app-all-branches-by-ifsc',
  imports: [CommonModule,RouterLink,MatButtonModule,MatIconModule],
  templateUrl: './all-branches-by-ifsc.component.html',
  styleUrl: './all-branches-by-ifsc.component.scss'
})
export class AllBranchesByIfscComponent {
  branchesData: any[] = [];
  data:any;
  constructor(private bank:RuleService,private router: Router){
  }
  ngOnInit(): void {
    try {
      const storedBranches = localStorage.getItem('allBranchesByIfsc');
      console.log('Raw localStorage data:', storedBranches);
      if (storedBranches) {
        this.branchesData = JSON.parse(storedBranches);
        console.log('Parsed branchesData:', this.branchesData);
      } else {
        console.warn('No BranchesByIfsc data found in localStorage.');
      }
    } catch (error) {
      console.error('Error parsing localStorage data:', error);
    }
  }
  deleteBranch(branch:any){
    this.bank.deleteBranch(branch).subscribe(
      (response:any) => {
        console.log(response);
        this.data = response.data;
        alert("Branch deleted successfully");
        this.router.navigate(['/branches']);
      },
      error => {
        console.log(error);
        alert("Error deleting branch");
      }
    );
  }
}
