import { Component, OnInit } from '@angular/core';
import {MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-dialog-vip',
  templateUrl: './dialog-vip.component.html',
  styleUrls: ['./dialog-vip.component.css']
})
export class DialogVipComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DialogVipComponent>) { }

  ngOnInit(): void {
  }

}
