import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Team } from '../teamClass/team';
import { RuleService } from '../service/rule.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-new-team',
  imports: [RouterLink,FormsModule,CommonModule],
  templateUrl: './new-team.component.html',
  styleUrl: './new-team.component.scss'
})
export class NewTeamComponent {
  model: Team = new Team(); 
  constructor(private team:RuleService){
    }
    teamData: any[] = [];
  onSubmit(form:NgForm){
    if(form.invalid){
      form.control.markAllAsTouched();
      return;
    }
    this.team.enterTeam(this.model).subscribe(
      (response:any) => {
        console.log(response);
        this.teamData = response.data;
        alert("Team/Service submitted successfully");
        form.resetForm();  
        this.model = new Team();
      },
      error => {
        console.log(error);
        alert("Team/Service insertion error");
      }
    );
    console.log(form.value);
  }
}
