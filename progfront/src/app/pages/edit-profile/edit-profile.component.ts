import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { EditUser } from 'src/app/services/EditUser';
import { LoginService } from 'src/app/services/login.service';
import { User } from 'src/app/services/User';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  /*public userEdit:any;
  public newUserData = {
    "firstName":'',
    "lastName":'',
    "email":'',
    "phone":'',
  }*/

  /*
  public currentUserId: number=this.login.getUser().id
  public empId:any =this.login.getUser().id;
  */
  constructor(private login:LoginService,private user:UserService,private aroute:ActivatedRoute,private router:Router,private snack:MatSnackBar) { }
  public uid:number=0;
  public userEdit:any={};



  ngOnInit(): void {
    //console.log(this.currentUserId);
    /*this.userEdit=this.login.getUser();
    console.log(this.user
      .getUser(this.currentUserId));*/
    //this.uid = this.aroute.snapshot.params['id'] as number;
    this.uid = this.login.getUser().id;
      console.log(this.uid);
    this.user.getUser(this.uid).subscribe(
      (data:any)=>{
        this.userEdit=data;
        console.log(this.userEdit);
      },
      (error)=>{
        console.log(error)
      }
    );
    }


    updateEmployee(){
      /*console.log("id:"+userId+" User"+JSON.stringify(<EditUser>this.newUserData));
      this.user.editEmployee(userId,this.newUserData).subscribe(
        
      );*/
      this.user.editEmployee(this.userEdit).subscribe()
      //this.router.navigate(["/admin/profile"]);
    }

}
