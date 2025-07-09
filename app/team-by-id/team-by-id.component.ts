import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { RuleService } from '../service/rule.service';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-team-by-id',
  standalone: true,
  imports: [CommonModule, RouterLink, MatButtonModule, MatIconModule],
  templateUrl: './team-by-id.component.html',
  styleUrl: './team-by-id.component.scss'
})
export class TeamByIdComponent implements OnInit {
  teamsData: any[] = [];

  constructor(private team: RuleService) {}

  ngOnInit(): void {
    try {
      const storedTeam = localStorage.getItem('teamById');
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
