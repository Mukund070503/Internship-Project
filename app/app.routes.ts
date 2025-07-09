import { Routes } from '@angular/router';
import { ReloadComponent } from './reload/reload.component';
import { NewRuleComponent } from './new-rule/new-rule.component';
import { EditRuleComponent } from './edit-rule/edit-rule.component';
import { ReloadTeamComponent } from './reload-team/reload-team.component';
import { NewTeamComponent } from './new-team/new-team.component';
import { ClientServiceComponent } from './client-service/client-service.component';
import { UpdateTeamComponent } from './update-team/update-team.component';
import { AdharServiceComponent } from './adhar-service/adhar-service.component';
import { PanServiceComponent } from './pan-service/pan-service.component';
import { SIdFilterComponent } from './s-id-filter/s-id-filter.component';
import { IdFilterComponent } from './id-filter/id-filter.component';
import { TeamByIdComponent } from './team-by-id/team-by-id.component';
import { TeamBySIdComponent } from './team-by-sid/team-by-sid.component';
import { BankComponent } from './bank/bank.component';
import { BranchesComponent } from './branches/branches.component';
import { AllBanksByBankCodeComponent } from './all-banks-by-bank-code/all-banks-by-bank-code.component';
import { AllBranchesByIfscComponent } from './all-branches-by-ifsc/all-branches-by-ifsc.component';
import { NewBankComponent } from './new-bank/new-bank.component';
import { NewBranchComponent } from './new-branch/new-branch.component';
import { UpdateBankComponent } from './update-bank/update-bank.component';
import { UpdateBranchComponent } from './update-branch/update-branch.component';

export const routes: Routes = [
    {path: 'reload', component: ReloadComponent},
    {path: 'new-rule', component: NewRuleComponent},
    {path: 'editRule', component: EditRuleComponent},
    {path: 'reload-team', component: ReloadTeamComponent},
    {path: 'new-team', component: NewTeamComponent},
    {path: 'client-service', component: ClientServiceComponent},
    {path: 'update-team', component: UpdateTeamComponent},
    {path: 'adhar-service', component: AdharServiceComponent},
    {path: 'pan-service', component: PanServiceComponent},
    {path: 's-id-filter', component: SIdFilterComponent},
    {path: 'id-filter', component: IdFilterComponent},
    {path: 'team-by-id', component: TeamByIdComponent},
    {path: 'team-by-sid', component: TeamBySIdComponent},
    {path: 'bank', component: BankComponent},
    {path: 'branches', component: BranchesComponent},
    {path: 'all-banks-by-bank-code', component: AllBanksByBankCodeComponent},
    {path: 'all-branches-by-ifsc', component: AllBranchesByIfscComponent},
    {path: 'new-bank', component: NewBankComponent},
    {path: 'new-branch', component: NewBranchComponent},
    {path: 'update-bank', component: UpdateBankComponent},
    {path: 'update-branch', component: UpdateBranchComponent},
];

