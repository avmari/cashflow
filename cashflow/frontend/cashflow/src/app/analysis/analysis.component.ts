import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogVipComponent } from '../dialog-vip/dialog-vip.component';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-analysis',
  templateUrl: './analysis.component.html',
  styleUrls: ['./analysis.component.css']
})
export class AnalysisComponent implements OnInit {

  selected = 'option2';
  constructor(public dialog: MatDialog, public userService: UserService) { }

  ngOnInit(): void {
  }

  createVIPDialog(){
    let dialogRef = this.dialog.open(DialogVipComponent, {
      height: '200px',
      width: '600px',
    });
  }
}
