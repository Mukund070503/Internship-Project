import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { Client } from '../ClientClass/Client';
import { RuleService } from '../service/rule.service';

@Component({
  selector: 'app-adhar-service',
  imports: [FormsModule,RouterLink],
  templateUrl: './adhar-service.component.html',
  styleUrl: './adhar-service.component.scss'
})
export class AdharServiceComponent {
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
  this.client.adharApi(this.model).subscribe(
    (response:any) => {
      console.log('response:',response);
      console.log('token_Message:', response.token_Message);
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
      alert("Error executing AdharApi");
    }
  );
  console.log(form.value);
}
}

