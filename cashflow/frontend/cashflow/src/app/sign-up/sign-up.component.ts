import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  signUpForm: FormGroup;
  submitted = false;
  loading = false;
  
  constructor(private formBuilder: FormBuilder) { 
    this.signUpForm = this.formBuilder.group({
      username: ['', Validators.required],
      email: ['', Validators.email],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  get f() { return this.signUpForm.controls; }

  onSubmit(){

  }

}
