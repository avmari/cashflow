import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  public currUser?: User;

  constructor(private http: HttpClient) { }

  becomeVIP(){
    this.http.post(`api/users/requestVIP`, this.currUser).subscribe( (value: User) => { 
      this.currUser = value; });
  }

  signIn(user: User){
    return this.http.post(`api/users/signIn`, user);
  }

  signUp(user: User){
    return this.http.post(`api/users/signUp`, user);
  }

}
