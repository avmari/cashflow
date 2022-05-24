import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Transaction } from '../models/transaction';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http: HttpClient, private userService: UserService) { }

  createTransaction(transaction: Transaction){
    return this.http.post(`api/transactions/createTransaction`, transaction);
  }

  getExpenses(beginning: Date, ending: Date){
    return this.http.get(`api/transactions/getExpenses/${this.userService.currUser?.id}/${beginning}/${ending}`);
  }

  getExpenseDistribution(beginning: Date, ending: Date){
    return this.http.get(`api/transactions/getExpenseDistribution/${this.userService.currUser?.id}/${beginning}/${ending}`);
  }
}
