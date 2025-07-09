//import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import {FormsModule, NgForm} from '@angular/forms';
import { Reload } from '../ruleClass/reload';
import { RuleService } from '../service/rule.service';
import { RouterLink } from '@angular/router';
@Component({
  selector: 'app-new-rule',
  standalone: true,
  imports: [FormsModule,RouterLink
  // NgIf
  ],
  templateUrl: './new-rule.component.html',
  styleUrl: './new-rule.component.scss'
})
export class NewRuleComponent {
model: Reload = new Reload(); 
constructor(private rule:RuleService){
  }
  ruleData: any[] = [];
onSubmit(form:NgForm){
  if(form.invalid){
    form.control.markAllAsTouched();
    return;
  }
  this.rule.enterRule(this.model).subscribe(
    (response:any) => {
      console.log(response);
      this.ruleData = response.data;
      alert("Rule submitted successfully");
      form.resetForm();  
      this.model = new Reload();
    },
    error => {
      console.log(error);
      alert("Rule insertion error");
    }
  );
  console.log(form.value);
}
}
