import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { BudgetComponent } from './budget/budget.component';
import { AnalysisComponent } from './analysis/analysis.component';
import { AdministratorComponent } from './administrator/administrator.component';

const routes: Routes = [
  { path: 'sign-in', component: SignInComponent },
  { path: 'sign-up', component: SignUpComponent },
  { path: 'budget', component: BudgetComponent },
  { path: 'analysis', component: AnalysisComponent },
  { path: 'admin', component: AdministratorComponent },
  { path: '', redirectTo: '/sign-in', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
