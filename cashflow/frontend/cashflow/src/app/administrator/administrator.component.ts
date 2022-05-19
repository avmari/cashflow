import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-administrator',
  templateUrl: './administrator.component.html',
  styleUrls: ['./administrator.component.css']
})
export class AdministratorComponent implements OnInit {
  usersRequested: User[] = [];

  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.adminService.getUsersWithRequestedStatus().subscribe((data: User[]) => {
      this.usersRequested = data;
    })
  }

  setVIPStatus(user: User){
    this.adminService.setVIPStatus(user);
    this.usersRequested.splice(this.usersRequested.findIndex(value => value.id == user.id), 1);
  }

}
