import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Sphere } from '../models/sphere';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class SphereService {

  constructor(private http: HttpClient, private userService: UserService) { }

  createSphere(sphere: Sphere){
    return this.http.post<Sphere>(`api/spheres/createSphere/`, sphere);
  }

  getAllUserSpheres(){
    return this.http.get<Sphere[]>(`api/spheres/getAllUserSpheres/${this.userService.currUser?.id}`);
  }
}
