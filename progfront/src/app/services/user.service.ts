import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginComponent } from '../pages/login/login.component';
import baseUrl from './helper';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private restUrl : string="http://localhost:8080/user";
  httpOptions = {
    headers: new HttpHeaders({
    'Content-Type':'application/json',
    })
  };

  constructor(
    private http:HttpClient,
  ) { }

  
  //addEmployee
  public addEmployee(emp : any){
    return this.http.post(`${baseUrl}user/`,emp);
  }
  //view Employees
  public getAllEmployees():Observable<User[]>{
    return this.http.get<User[]>(`${baseUrl}user/all`);
  }
  //edit Employee
  editEmployee(emp:User){
    console.log("emp ::",emp);
    return this.http.put(`${baseUrl}user/edit/`,emp);

  }
  //getEmployee
  getUser(id:any){
    return this.http.get(`${baseUrl}user/byId/${id}`);
  }

}
