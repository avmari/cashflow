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
  view: any = [500, 300];

  legend: boolean = false;
  showLabels: boolean = true;
  animations: boolean = true;
  xAxis: boolean = true;
  yAxis: boolean = true;
  showYAxisLabel: boolean = true;
  showXAxisLabel: boolean = true;
  xAxisLabel: string = 'Month';
  yAxisLabel: string = 'Expenses';
  timeline: boolean = true;

  colorScheme: Color = {
    name: 'myScheme',
    selectable: true,
    group: ScaleType.Ordinal,
    domain: ['#00a86b'],
  };

  selected = 'option2';
  constructor(public dialog: MatDialog, public userService: UserService, 
    private transactionService: TransactionService) { }

  ngOnInit(): void {
    this.getData();
  }

  getData(){
    this.transactionService.getExpenses().subscribe((data: any) => {
      this.expenses = data;
    })
  }

  createVIPDialog(){
    let dialogRef = this.dialog.open(DialogVipComponent, {
      height: '200px',
      width: '600px',
    });
  }
}
