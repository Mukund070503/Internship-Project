import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Team } from '../teamClass/team';
import { RuleService } from '../service/rule.service';

@Component({
  selector: 'app-update-team',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './update-team.component.html',
  styleUrls: ['./update-team.component.scss']
})
export class UpdateTeamComponent implements OnInit {
  model: Team = new Team();
  teamData: any[] = [];

  constructor(private teamService: RuleService, private router: Router) {}

  ngOnInit(): void {
    const storedTeam = localStorage.getItem('editTeam');
    console.log('Raw localStorage data:', storedTeam);

    if (storedTeam) {
      try {
        const parsedTeam = JSON.parse(storedTeam);
        console.log('Parsed Team:', parsedTeam);

        this.model = new Team({
          id: parsedTeam.id,
          teamName: parsedTeam.team_name,
          teamDl: parsedTeam.team_dl,
          applicationName: parsedTeam.application_name,
          serviceId: parsedTeam.service_id,
          description: parsedTeam.description,
          averageTraffic: parsedTeam.Average_Traffic,
          peakTraffic: parsedTeam.Peak_Traffic,
          peakTrafficHrs: parsedTeam.Peak_Traffic_Hrs
        });        

        console.log('Loaded Model:', this.model);
      } catch (error) {
        console.error('Error parsing editTeam:', error);
      }
    } else {
      console.warn('No editTeam found in localStorage');
    }
  }

  onSubmit(form: NgForm): void {
    console.log('Submitting this.model:', this.model);
    this.teamService.updateTeam(this.model).subscribe(
      (response: any) => {
        console.log('response:',response);
        this.teamData = response.data;
        console.log('Team Data:',this.teamData);
        alert('Team edited successfully');
        this.router.navigate(['/reload-team']);
      },
      error => {
        console.error(error);
        alert('Error editing team');
      }
    );
    console.log('Form value:',form.value);
  }
}
