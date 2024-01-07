import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit
{
  constructor(private userService:UserService,private router:Router)
  {


  }
   users:User[]=[];
   passwordVisible: boolean = false;

  togglePasswordVisibility() {
    this.passwordVisible = !this.passwordVisible;
  }
   
   ngOnInit():void
   {
    this.getUsers();
   }


   private getUsers()
   {
      this.userService.getUsersList().subscribe(data=>
        {
          this.users=data;
        });
   }
   updateUser(userId:number)
   {
    this.router.navigate(['users',userId]);
   }
   deleteUser(userId:number):void
   {
    this.userService.deleteUser(userId).subscribe(data=>
      {
        console.log(data);
       this.getUsers();
      }
      )
   }
}



