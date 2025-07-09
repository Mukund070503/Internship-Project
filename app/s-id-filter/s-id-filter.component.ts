import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Team } from '../teamClass/team';
import { RuleService } from '../service/rule.service';

@Component({
  selector: 'app-s-id-filter',
  imports: [FormsModule,RouterLink],
  templateUrl: './s-id-filter.component.html',
  styleUrl: './s-id-filter.component.scss'
})
export class SIdFilterComponent {
  model: Team = new Team(); 
  teamData: any[] = [];

  constructor(private team: RuleService, private router: Router) {}

  onSubmit(form: NgForm) {
    if (form.invalid) {
      form.control.markAllAsTouched();
      return;
    }

    this.team.allClientsBySId(this.model.serviceId!).subscribe(
      (response: any) => {
        console.log(response);
        this.teamData = response.data.TeamList;
        alert("Data fetched successfully");
        localStorage.setItem('teamBySId', JSON.stringify(this.teamData)); 
        console.log('Stored Teams:', this.teamData);
        this.router.navigate(['/team-by-sid']);
      },
      error => {
        console.log(error);
        alert("Error fetching data");
      }
    );

    console.log(form.value);
  }
}
