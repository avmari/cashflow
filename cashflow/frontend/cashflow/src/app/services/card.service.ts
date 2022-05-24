import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Card } from '../models/card';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class CardService {

  constructor(private http: HttpClient, private userService: UserService) { }

  getRemainingFunds(){
    return this.http.get<number>(`api/users/getRemainingFunds/${this.userService.currUser?.id}`);
  }

  getTotalAmountSpent(){
    return this.http.get<number>(`api/users/getTotalAmountSpent/${this.userService.currUser?.id}`)
  }

  createCard(card: Card){
    return this.http.post<Card>(`api/cards/createCard/`, card);
  }

  getAllUserCards(){
    return this.http.get<Card[]>(`api/cards/getAllUserCards/${this.userService.currUser?.id}`);
  }

  editCard(card: Card){
    return this.http.post<Card>(`api/cards/editCard/`, card);
  }

}
