import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient, private userService: UserService) { }

  getUsersWithRequestedStatus(){
    return this.http.get<User[]>(`api/users/requestedVIP`);
  }

  setVIPStatus(user: User){
    return this.http.post(`api/users/setVIP`, user).subscribe((data) =>{
      this.userService.currUser = data;
    });
  }
}
