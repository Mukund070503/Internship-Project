import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { RuleService } from '../service/rule.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-client-service',
  imports: [CommonModule,RouterLink],
  templateUrl: './client-service.component.html',
  styleUrl: './client-service.component.scss'
})
export class ClientServiceComponent implements OnInit{
  clientsData: any[] = [];
  constructor(private clients:RuleService){
  }
  ngOnInit(): void { 
    this.clients.allClients().subscribe(
      (response:any) => {
        console.log("response:",response);
        this.clientsData = response;
      },
      error => {
        console.log(error);
      }
    );
  }
  service(client: any): void {
    const clientData = {
      ...client,
    };
    localStorage.setItem('clientData', JSON.stringify(clientData)); 
    console.log('Stored Team:', clientData);
  }
}
