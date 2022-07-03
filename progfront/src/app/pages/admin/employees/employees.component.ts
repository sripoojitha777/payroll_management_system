import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  public employees = [

  ] as any;
  constructor(private user:UserService) { }

  ngOnInit(): void {
    this.user.getAllEmployees().subscribe(data=>this.employees=data);

  }

}
