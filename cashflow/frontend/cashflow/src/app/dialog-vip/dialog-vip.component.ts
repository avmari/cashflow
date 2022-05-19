import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-dialog-vip',
  templateUrl: './dialog-vip.component.html',
  styleUrls: ['./dialog-vip.component.css']
})
export class DialogVipComponent implements OnInit {
  userStatus?: number;

  constructor(public dialogRef: MatDialogRef<DialogVipComponent>, private userService: UserService) { }

  ngOnInit(): void {
    this.userStatus = this.userService.currUser?.status;
  }

  becomeVIP(){
    this.userService.becomeVIP();
    this.userStatus = this.userService.currUser?.status;
  }

}
