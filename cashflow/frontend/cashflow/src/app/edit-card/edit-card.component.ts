import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Card } from '../models/card';
import { CardService } from '../services/card.service';

@Component({
  selector: 'app-edit-card',
  templateUrl: './edit-card.component.html',
  styleUrls: ['./edit-card.component.css']
})
export class EditCardComponent implements OnInit {
  editCardForm: FormGroup;

  constructor(private formBuilder: FormBuilder, public dialogRef: MatDialogRef<EditCardComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private cardService: CardService) { 
    this.editCardForm = this.formBuilder.group({
      name:[data.name, Validators.required],
      amount:['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  get name(){
    return this.editCardForm.get("name");
  }

  get amount(){
    return this.editCardForm.get("amount");
  }

  onSubmit(){
    let card: Card = {
      id: this.data.id,
      user: this.data.user,
      name: this.name?.value,
      amount: this.amount?.value,
      icon: this.data.icon
    }
    this.cardService.editCard(card).subscribe();
  }
}
