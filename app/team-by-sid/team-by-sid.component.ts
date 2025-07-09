import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { RuleService } from '../service/rule.service';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-team-by-sid',
  imports: [CommonModule, RouterLink, MatButtonModule, MatIconModule],
  templateUrl: './team-by-sid.component.html',
  styleUrl: './team-by-sid.component.scss'
})
export class TeamBySIdComponent {
teamsData: any[] = [];

  constructor(private team: RuleService) {}

  ngOnInit(): void {
    try {
      const storedTeam = localStorage.getItem('teamBySId');
      console.log('Raw localStorage data:', storedTeam);
      if (storedTeam) {
        this.teamsData = JSON.parse(storedTeam);
        console.log('Parsed teamsData:', this.teamsData);
      } else {
        console.warn('No teamById data found in localStorage.');
      }
    } catch (error) {
      console.error('Error parsing localStorage data:', error);
    }
  }

  setEditRule(team: any): void {
    const teamData = { ...team };
    localStorage.setItem('editTeam', JSON.stringify(teamData));
    console.log('Stored Team:', teamData);
  }
}
