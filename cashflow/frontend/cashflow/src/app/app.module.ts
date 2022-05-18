import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AppRoutingModule } from './app-routing.module';
import { BudgetComponent } from './budget/budget.component';
import { AdministratorComponent } from './administrator/administrator.component';
import { MatIconModule } from '@angular/material/icon';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DialogVipComponent } from './dialog-vip/dialog-vip.component';
import { MatDialogModule } from '@angular/material/dialog';
import { AnalysisComponent } from './analysis/analysis.component';
import { MatTabsModule } from '@angular/material/tabs';
import { MatOptionModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { CreateCardComponent } from './create-card/create-card.component';
import { CreateSphereComponent } from './create-sphere/create-sphere.component';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SignUpComponent,
    BudgetComponent,
    AdministratorComponent,
    AnalysisComponent,
    DialogVipComponent,
    CreateCardComponent,
    CreateSphereComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MatIconModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatTabsModule,
    MatOptionModule,
    MatSelectModule,
    MatDatepickerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
