import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  loginForm: FormGroup;
  isSignInFailed = false;
  
  constructor(private formBuilder: FormBuilder, public userService: UserService, 
    private router: Router) { 
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.email],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    
  }


  get login() {
    return this.loginForm.get("email");
  }

  get password() {
    return this.loginForm.get("password");
  }


  onSubmit(){
    let user: User = new User();
    user.email = this.login?.value;
    user.password = this.password?.value;

    this.userService.signIn(user).subscribe(
      (data: User) => {
        this.userService.currUser = data;
        this.router.navigateByUrl("/budget");
      },
      (error: any) =>{
        console.log(error);
        this.isSignInFailed = true;
      }
    );
  }
}
