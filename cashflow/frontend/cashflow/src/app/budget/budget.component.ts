import { CdkDragDrop } from '@angular/cdk/drag-drop';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CreateCardComponent } from '../create-card/create-card.component';
import { CreateSphereComponent } from '../create-sphere/create-sphere.component';
import { DialogVipComponent } from '../dialog-vip/dialog-vip.component';
import { EditCardComponent } from '../edit-card/edit-card.component';
import { Card } from '../models/card';
import { Sphere } from '../models/sphere';
import { CardService } from '../services/card.service';
import { SphereService } from '../services/sphere.service';
import { UserService } from '../services/user.service';
import { TransactionComponent } from '../transaction/transaction.component';

@Component({
  selector: 'app-budget',
  templateUrl: './budget.component.html',
  styleUrls: ['./budget.component.css']
})
export class BudgetComponent implements OnInit {
  totalAmountSpent: number = 0;
  remainingFunds: number = 0;
  cards: Card[] = [];
  spheres: Sphere[] = [];

  constructor(public dialog: MatDialog, public userService: UserService, private cardService: CardService,
    private sphereService: SphereService) { }

  ngOnInit(): void {
    this.getData();
  }

  getData(){
    this.cardService.getRemainingFunds().subscribe((data: number) => {
      this.remainingFunds = data;
    })

    this.cardService.getTotalAmountSpent().subscribe((data: number) => {
      this.totalAmountSpent = data;
    })

    this.cardService.getAllUserCards().subscribe((data: Card[]) => {
      this.cards = data;
    })

    this.sphereService.getAllUserSpheres().subscribe((data: Sphere[]) => {
      this.spheres = data;
    })
  }
  
  drop(event: CdkDragDrop<any[]>){
    let data = { 
      card: event.previousContainer.data[event.previousIndex], 
      spheres: this.spheres 
    };
    this.createTransactionDialog(data);
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
    dialogRef.afterClosed().subscribe((data: any) => {
      this.cardService.getAllUserCards().subscribe((cards: Card[]) => {
        this.cards = cards;
      })
    })
  }

  createSphereDialog(){
    let dialogRef = this.dialog.open(CreateSphereComponent, {
      height: '300px',
      width: '250px',
    });
    dialogRef.afterClosed().subscribe((data) => {
      this.sphereService.getAllUserSpheres().subscribe((spheres: Sphere[]) => {
        this.spheres = spheres;
      })
    })
  }

  createTransactionDialog(data: any){
    let dialogRef = this.dialog.open(TransactionComponent, {
      data,
      height: '350px',
      width: '300px',
    });
    dialogRef.afterClosed().subscribe((data) => {
      this.getData();
    })
  }

  createEditCardDialog(data: any){
    let dialogRef = this.dialog.open(EditCardComponent, {
      data,
      height: '350px',
      width: '300px',
    });
    dialogRef.afterClosed().subscribe((data) => {
      this.cardService.getRemainingFunds().subscribe((data: number) => {
        this.remainingFunds = data;
      })
      this.cardService.getAllUserCards().subscribe((data: Card[]) => {
        this.cards = data;
      })
    })
  }
  
}
