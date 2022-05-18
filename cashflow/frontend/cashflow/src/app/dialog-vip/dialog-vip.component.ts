import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-dialog-vip',
  templateUrl: './dialog-vip.component.html',
  styleUrls: ['./dialog-vip.component.css']
})
export class DialogVipComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DialogVipComponent>, public userService: UserService) { }

  ngOnInit(): void {
  }

}
