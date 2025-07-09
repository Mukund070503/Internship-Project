import { Component } from '@angular/core';
import { Client } from '../ClientClass/Client';
import { Router, RouterLink } from '@angular/router';
import { RuleService } from '../service/rule.service';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-pan-service',
  imports: [FormsModule,RouterLink],
  templateUrl: './pan-service.component.html',
  styleUrl: './pan-service.component.scss'
})
export class PanServiceComponent {
  model: Client = new Client(); 
  Data: any[] = [];
constructor(private client:RuleService,  private router: Router){
  }

  ngOnInit(): void {
      const storedClient = localStorage.getItem('clientData');
      console.log('Raw localStorage data:', storedClient);
  
      if (storedClient) {
        try {
          const parsedClient = JSON.parse(storedClient);
          console.log('Parsed Client:', parsedClient);
  
          this.model = new Client({
            id: parsedClient.id,
            service_id: parsedClient.serviceId,
            client_id: parsedClient.clientId,
            client_name: parsedClient.clientName,

          });        
  
          console.log('Loaded Client:', this.model);
        } catch (error) {
          console.error('Error parsing client:', error);
        }
      } else {
        console.warn('No client found in localStorage');
      }
    }
  
onSubmit(form:NgForm){
  if(form.invalid){
    form.control.markAllAsTouched();
    return;
  }
  this.client.panApi(this.model).subscribe(
    (response:any) => {
      console.log(response);
      this.Data = response.data;
      console.log(form.value);
      if (response.token_Message!=null) {
        alert('Token value: ' + response.token_Message);
      } else {
        alert('Execution successful');
      }
      this.router.navigate(['/client-service']);
    },
    error => {
      console.log(error);
      alert("Error executing PanApi");
    }
  );
}
}

