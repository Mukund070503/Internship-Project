import { Component, OnInit} from '@angular/core';
import { RuleService } from '../service/rule.service';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import {MatButtonModule} from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
@Component({
  selector: 'app-reload',
  standalone: true,
  imports: [CommonModule, RouterLink, MatButtonModule, MatIconModule],
  templateUrl: './reload.component.html',
  styleUrl: './reload.component.scss'
})
export class ReloadComponent {
  rulesData: any[] = [];
constructor(private rule:RuleService){
}
ngOnInit(): void { 
  this.rule.allRules().subscribe(
    (response:any) => {
      console.log(response);
      this.rulesData = response.data;
    },
    error => {
      console.log(error);
    }
  );

}
setEditRule(serviceId: string,rule: any): void {

  const ruleData = {
    serviceId: serviceId,
    ...rule,
  };
  localStorage.setItem('editRule', JSON.stringify(ruleData)); 
  console.log('Stored Rule:', ruleData);
}
}
