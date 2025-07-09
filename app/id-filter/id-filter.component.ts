import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { RuleService } from '../service/rule.service';
import { Team } from '../teamClass/team';

@Component({
  selector: 'app-id-filter',
  imports: [FormsModule, RouterLink],
  templateUrl: './id-filter.component.html',
  styleUrls: ['./id-filter.component.scss']
})
export class IdFilterComponent {
  model: Team = new Team(); 
  teamData: any[] = [];

  constructor(private team: RuleService, private router: Router) {}

  onSubmit(form: NgForm) {
    if (form.invalid) {
      form.control.markAllAsTouched();
      return;
    }

    this.team.allClientsById(this.model.id!).subscribe(
      (response: any) => {
        console.log(response);
        this.teamData = response.data.TeamList;
        alert("Data fetched successfully");
        localStorage.setItem('teamById', JSON.stringify(this.teamData)); 
        console.log('Stored Teams:', this.teamData);
        this.router.navigate(['/team-by-id']);
      },
      error => {
        console.log(error);
        alert("Error fetching data");
      }
    );

    console.log(form.value);
  }
}
