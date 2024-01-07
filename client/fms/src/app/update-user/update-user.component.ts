import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user.service';
import { User } from '../user';
import { catchError, map } from 'rxjs/operators';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit
{
     userId!:number;
     user:User=new User();
     constructor(private userService:UserService,private router:Router,
       private route:ActivatedRoute)
     {
  
     }

     

ngOnInit(): void {
  this.user = new User();
  this.userId = this.route.snapshot.params['userId'];

  this.userService.getUserById(this.userId).pipe(
    map((data: User) => {
      this.user = data;
    }),
    catchError((error: any) => {
      console.log(error);
      throw error; // Re-throw the error to propagate it further
    })
  ).subscribe();
}

      




     


    


     onSubmit()
     {
       this.updateUser();
     }
     updateUser()
     {
       this.userService.updateUser(this.userId,this.user).subscribe(data=>
         {this.gotoUserList()});
     }
     gotoUserList()
     {
       this.router.navigate(['/users']);
     }


    
}


