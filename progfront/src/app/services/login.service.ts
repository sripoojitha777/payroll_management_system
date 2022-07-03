import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject=new Subject<boolean>();

  constructor(private http:HttpClient) { }


  //generate Token
  public generateToken(userLoginDetails:any){
    return this.http.post(`${baseUrl}generate-token`,userLoginDetails);
  }

  //current user
  public getCurrentUser(){
    return this.http.get(`${baseUrl}current-user`);
  }

  //login user
  public loginUser(token:any){
    localStorage.setItem('token',token);
    
    return true;
  }

  //check if user Logged in
  public isLoggedIn(){
    let tokenstr=localStorage.getItem('token')
    if(tokenstr==undefined || tokenstr==null || tokenstr==''){
      return false;
    }
    else{
      return true
    }
  }

  //remove token from localStorage
  public logout(){
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;
  }

  //get token
  public getToken(){
    return localStorage.getItem('token');
  }

  //set user detail
  public setUser(user:any){
    localStorage.setItem('user',JSON.stringify(user));
  }

  //
  public getUser(){
    let userStr=localStorage.getItem('user');
    if(userStr!=null)
    {
      return JSON.parse(userStr);
    }
    else{
      this.logout();
      return null;
    }
  }

  //get Role 
  public getUserRole(){
    let user=this.getUser();
    return user.authorities[0].authority;
  }

  
}
