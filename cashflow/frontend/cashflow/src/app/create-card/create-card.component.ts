import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-create-card',
  templateUrl: './create-card.component.html',
  styleUrls: ['./create-card.component.css']
})
export class CreateCardComponent implements OnInit {
  createCardForm: FormGroup;

  constructor(private formBuilder: FormBuilder, public dialogRef: MatDialogRef<CreateCardComponent>) { 
    this.createCardForm = this.formBuilder.group({
      name:['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  onSubmit(){}

}
