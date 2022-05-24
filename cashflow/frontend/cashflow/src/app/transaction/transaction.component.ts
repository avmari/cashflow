import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Transaction } from '../models/transaction';
import { TransactionService } from '../services/transaction.service';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  transactionForm: FormGroup;

  constructor(private formBuilder: FormBuilder, public dialogRef: MatDialogRef<TransactionComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any, private transactionService: TransactionService) {
    this.transactionForm = this.formBuilder.group({
      amount: ['', Validators.required],
      sphere: ['', Validators.required]
    });
   }

  ngOnInit(): void {
  }

  get amount(){ 
    return this.transactionForm.get("amount");
  }

  get sphere(){
    return this.transactionForm.get("sphere");
  }

  onSubmit(){
    let transaction: Transaction = {
      card: this.data.card,
      sphere: this.sphere?.value,
      amount: this.amount?.value,
      date: new Date()
    }
    console.log(transaction);
    this.transactionService.createTransaction(transaction).subscribe();
  }
}
