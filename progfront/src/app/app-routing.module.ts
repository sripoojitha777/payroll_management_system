import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { EmployeesComponent } from './pages/admin/employees/employees.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { EditProfileComponent } from './pages/edit-profile/edit-profile.component';
import { UserDashboardComponent } from './pages/employee/user-dashboard/user-dashboard.component';
import { WelcomeEmpComponent } from './pages/employee/welcome-emp/welcome-emp.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { AdminGuard } from './services/admin.guard';
import { EmployeeGuard } from './services/employee.guard';

const routes: Routes = [
  {path:'signup',component: SignupComponent,pathMatch:'full'},
  {path:'login',component:LoginComponent,pathMatch:'full'},
  {path:'',component:HomeComponent,pathMatch:'full'},
  {path:'admin',component:DashboardComponent,canActivate:[AdminGuard],
    children:[
      {
        path:'',component:WelcomeComponent,
      },
      {
        path:'profile',component:ProfileComponent,
      },
      {
        path:'edit',component:EditProfileComponent,
      },
      {
        path:'employees',component:EmployeesComponent,
      }

    ]
  },
  {path:'user',component:UserDashboardComponent,canActivate:[EmployeeGuard],
  children:[
    {
      path:'',component:WelcomeEmpComponent,
    },
    {
      path:'edit',component:EditProfileComponent,
    },
    {
      path:'profile',component:ProfileComponent,
    },
  ]
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
