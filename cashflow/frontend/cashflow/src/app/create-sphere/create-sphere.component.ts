import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-create-sphere',
  templateUrl: './create-sphere.component.html',
  styleUrls: ['./create-sphere.component.css']
})
export class CreateSphereComponent implements OnInit {
  createSphereForm: FormGroup;

  constructor(private formBuilder : FormBuilder, public dialogRef: MatDialogRef<CreateSphereComponent>) { 
    this.createSphereForm = this.formBuilder.group({
      name:['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  onSubmit(){}
}
