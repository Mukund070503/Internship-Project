export class Bank {

    bankCode?: string;
    name?: string;
    defaultIfsc?: string;
    isEnabled?: boolean;
    isImpsEnabled?: boolean;
    isLoadCashEnabled?: boolean;
    isUpiEnabled?: boolean;
    iin?: string;
    bankIconUrl?: string;
  
    ifsc?: string;
    address?: string;
    branchName?: string;
    city?: string;
    districtId?: number;
    micrCode?: string;
    phone?: string;
    stateCode?: string;

    constructor(init?: Partial<Bank>) {
    Object.assign(this, init);
  }
  }
  