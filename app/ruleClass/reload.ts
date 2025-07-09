export class Reload {
  ruleId?: number; 
  serviceId?: string;
  keyTemplate?: string;
  timeFrame?: string;
  amountLimit?: number;
  countLimit?: number;
  startDateTime?: string; 
  endDateTime?: string;
  precedence?: number;
  eligibility?: string;
  minAmount?: number;
  maxAmount?: number;
  status?: string;
  ruleCode?: string;
  ruleGroup?: string;

  constructor(init?: Partial<Reload>) {
    if (init) {
      Object.assign(this, init);
    }
  }
}
