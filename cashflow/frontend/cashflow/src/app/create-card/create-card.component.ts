import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Card } from '../models/card';
import { CardService } from '../services/card.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-create-card',
  templateUrl: './create-card.component.html',
  styleUrls: ['./create-card.component.css']
})
export class CreateCardComponent implements OnInit {
  createCardForm: FormGroup;

  constructor(private formBuilder: FormBuilder, public dialogRef: MatDialogRef<CreateCardComponent>,
    private cardService: CardService, private userService: UserService) { 
    this.createCardForm = this.formBuilder.group({
      name:['', Validators.required],
      amount:['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  get name(){
    return this.createCardForm.get("name");
  }

  get amount(){
    return this.createCardForm.get("amount");
  }

  onSubmit(){
    let card: Card = { 
      user: this.userService.currUser,
      name: this.name?.value,
      amount: this.amount?.value,
      icon: "credit_card"}
    this.cardService.createCard(card).subscribe();
  }


}
