import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Reload } from '../ruleClass/reload';
import { RuleService } from '../service/rule.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-edit-rule',
  imports: [FormsModule,RouterLink],
  templateUrl: './edit-rule.component.html',
  styleUrl: './edit-rule.component.scss'
})
export class EditRuleComponent {
  model: Reload = new Reload(); 
  convertToHTML5Date(dateString: string | null): string | null {
    if (!dateString) return null;
    return dateString.split('.')[0]; 
  }  
  constructor(private rule:RuleService, private router: Router){}
  ngOnInit(): void {
    const storedRule = localStorage.getItem('editRule'); 
    console.log('Raw localStorage data:', storedRule); 
    if (storedRule) {
      try {
        const parsedRule = JSON.parse(storedRule);
        console.log('Parsed Rule:', parsedRule);
        this.model = new Reload({
          ruleId: parsedRule.RULE_ID,
          serviceId: parsedRule.serviceId,
          keyTemplate: parsedRule.KEY_TEMPLATE,
          timeFrame: parsedRule.TIMEFRAME,
          amountLimit: parsedRule.AMOUNT_LIMIT,
          countLimit: parsedRule.COUNT_LIMIT,
          startDateTime: this.convertToHTML5Date(parsedRule.START_DATETIME) ?? undefined,
          endDateTime: this.convertToHTML5Date(parsedRule.END_DATETIME) ?? undefined,
          precedence: parsedRule.PRECEDENCE,
          eligibility: parsedRule.ELIGIBILITY,
          minAmount: parsedRule.MIN_AMOUNT,
          maxAmount: parsedRule.MAX_AMOUNT,
          status: parsedRule.STATUS,
          ruleCode: parsedRule.RULE_CODE,
          ruleGroup: parsedRule.RULE_GROUP
        });
  
        console.log('Loaded Model:', this.model);  
      } catch (error) {
        console.error('Error parsing editRule:', error);
      }
    } else {
      console.warn('No editRule found in localStorage');
    }
    console.log('Loaded Model:', this.model);

  }
  ruleData: any[] = [];
onSubmit(form:NgForm){
  this.rule.updateRule(this.model).subscribe(
    (response:any) => {
      console.log(response);
      this.ruleData = response.data;
      alert("Rule edited successfully");
      this.router.navigate(['/reload']);
    },
    error => {
      console.log(error);
      alert("Error editing rules");
    }
  );
  console.log(form.value);
}
}
