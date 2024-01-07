import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent  implements OnInit{

  buttonFlag: boolean = false; // Provide a default value
  username: string =''; // Provide a default value
  user: boolean = false; // Provide a default value
  admin: boolean = false; // Provide a default value

    constructor(){}

    ngOnInit(){
        this.user=false;
        this.admin=false;
        if(sessionStorage.getItem('userRole')==='user'){
            this.user=true;
        }else if(sessionStorage.getItem('userRole')==='admin'){
            this.admin=true;
        }
        // this.buttonFlag=this.authenticationService.isUserLoggedIn();
        //this.username=sessionStorage.getItem('username');
        if(this.username!=null)
            this.username=this.username.toUpperCase();
    }

}

  