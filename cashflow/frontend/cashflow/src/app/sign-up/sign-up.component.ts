import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  signUpForm: FormGroup;
  isSignUpFailed = false;
  
  constructor(private formBuilder: FormBuilder, private userService: UserService, 
    private router: Router) { 
    this.signUpForm = this.formBuilder.group({
      username: ['', Validators.required],
      email: ['', Validators.email],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  get f() { return this.signUpForm.controls; }

  get email() {
    return this.signUpForm.get("email");
  }

  get username() {
    return this.signUpForm.get("username");
  }

  get password() {
    return this.signUpForm.get("password");
  }


  onSubmit(){
    let user: User = new User();
    user.email = this.email?.value;
    user.name = this.username?.value;
    user.password = this.password?.value;

    this.userService.signUp(user).subscribe((data) => {
      this.router.navigateByUrl("/sign-in");
    },
    (error) => {
      this.isSignUpFailed = true;
    })
  }

}
