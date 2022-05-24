import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Sphere } from '../models/sphere';
import { SphereService } from '../services/sphere.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-create-sphere',
  templateUrl: './create-sphere.component.html',
  styleUrls: ['./create-sphere.component.css']
})
export class CreateSphereComponent implements OnInit {
  createSphereForm: FormGroup;

  constructor(private formBuilder : FormBuilder, public dialogRef: MatDialogRef<CreateSphereComponent>,
    private userService: UserService, private sphereService: SphereService) { 
    this.createSphereForm = this.formBuilder.group({
      name:['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  get name(){
    return this.createSphereForm.get("name");
  }

  onSubmit(){
    let sphere: Sphere = {
      user: this.userService.currUser,
      name: this.name?.value,
      icon: "more_horiz"
    }
    this.sphereService.createSphere(sphere).subscribe();
  }
}
