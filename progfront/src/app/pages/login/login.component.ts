import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLoginDetails={
    "username":'',
    "password":'',
  };

  constructor(private snack:MatSnackBar,private login:LoginService,private router:Router) { }

  ngOnInit(): void {}

  formSubmit(){
    if(this.userLoginDetails.username.trim()==''||this.userLoginDetails.username==null){
      this.snack.open("Username required",'',{
        duration: 2000,
      });
      return;
    }
    else if(this.userLoginDetails.password.trim()==''||this.userLoginDetails.password==null){
      this.snack.open("Password required",'',{
        duration: 2000,
      });
      return;
    }

    //request server to genrate token
    this.login.generateToken(this.userLoginDetails).subscribe(
      (data:any)=>{
        console.log("Succes");
        console.log(data);

        //login
        this.login.loginUser(data.token);

        this.login.getCurrentUser().subscribe(
          (user:any)=>{
            this.login.setUser(user);
            console.log(user);
            
            //redirect to Admin
            console.log("Check Role");
            console.log(this.login.getUserRole());
            if(this.login.getUserRole()=='Admin'){
              console.log("Its Admin");
              this.router.navigate(['admin']);
              this.login.loginStatusSubject.next(true);
            }
            //redirect to Normal
            else if(this.login.getUserRole()=='NORMAL'){
              console.log("Its Employee");
              this.router.navigate(['user']);
              this.login.loginStatusSubject.next(true);
            }
            else{
              this.login.logout();
              console.log("No such user");
            }
          }
        );
      },
      (error)=>{
        console.log("Error");
        console.log(error);
        this.snack.open("Invalid User!!",'',{
          duration:2000,
        });
      }
      )

  }
}
