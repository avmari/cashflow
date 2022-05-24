import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Color, ScaleType } from '@swimlane/ngx-charts';
import { DialogVipComponent } from '../dialog-vip/dialog-vip.component';
import { TransactionService } from '../services/transaction.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-analysis',
  templateUrl: './analysis.component.html',
  styleUrls: ['./analysis.component.css']
})
export class AnalysisComponent implements OnInit {

  expenses: any[] = [];
  expenseDistribution: any[] = [];

  beginning: Date = new Date();
  ending: Date = new Date();

  yAxisLabel: string = "Expenses";
  xAxisLabel: string = "Date";

  colorScheme: Color = {
    name: 'myScheme',
    selectable: true,
    group: ScaleType.Ordinal,
    domain: ['#00a86b'],
  };

  constructor(public dialog: MatDialog, public userService: UserService, 
    private transactionService: TransactionService) {
     }

  ngOnInit(): void {
  }

  getData(){
    this.transactionService.getExpenses(this.beginning, this.ending).subscribe((data: any) => {
      this.expenses = data;
    })
    this.transactionService.getExpenseDistribution(this.beginning, this.ending).subscribe((data: any) => {
      this.expenseDistribution = data;
      console.log(data);
    })
  }

  createVIPDialog(){
    let dialogRef = this.dialog.open(DialogVipComponent, {
      height: '200px',
      width: '600px',
    });
  }

  updateGraphics(){
    this.getData();
  }
}
