import { Component,OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { RuleService } from '../service/rule.service';
import { CommonModule } from '@angular/common';
import {MatButtonModule} from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-reload-team',
  imports: [CommonModule, RouterLink,MatButtonModule, MatIconModule],
  templateUrl: './reload-team.component.html',
  styleUrl: './reload-team.component.scss'
})
export class ReloadTeamComponent implements OnInit{
teamsData: any[] = [];
constructor(private team:RuleService){
}
ngOnInit(): void { 
  this.team.allTeams().subscribe(
    (response:any) => {
      console.log(response);
      this.teamsData = response.data.TeamList;
      console.log(this.teamsData);
    },
    error => {
      console.log(error);
    }
  );

}
setEditRule(team: any): void {
  const teamData = {
    ...team,
  };
  localStorage.setItem('editTeam', JSON.stringify(teamData)); 
  console.log('Stored Team:', teamData);
}
}
