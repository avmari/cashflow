import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CreateCardComponent } from '../create-card/create-card.component';
import { CreateSphereComponent } from '../create-sphere/create-sphere.component';
import { DialogVipComponent } from '../dialog-vip/dialog-vip.component';

@Component({
  selector: 'app-budget',
  templateUrl: './budget.component.html',
  styleUrls: ['./budget.component.css']
})
export class BudgetComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  createVIPDialog(){
    let dialogRef = this.dialog.open(DialogVipComponent, {
      height: '200px',
      width: '600px',
    });
  }
  
  createCardDialog(){
    let dialogRef = this.dialog.open(CreateCardComponent, {
      height: '300px',
      width: '250px',
    });
  }

  createSphereDialog(){
    let dialogRef = this.dialog.open(CreateSphereComponent, {
      height: '300px',
      width: '250px',
    });
  }

}
