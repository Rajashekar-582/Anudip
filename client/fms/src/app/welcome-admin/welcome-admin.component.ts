import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-welcome-admin',
  templateUrl: './welcome-admin.component.html',
  styleUrls: ['./welcome-admin.component.css']
})
export class WelcomeAdminComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  addScheduledFlight(): void{
    this.router.navigate(['scheduled/add']);
  }

  viewScheduledFlight(): void{
    this.router.navigate(['scheduledFlight/show']);
  }

  searchScheduledFlight(): void{
      this.router.navigate(['scheduledFlight/search']);
  }

  modifyScheduledFlight(): void{
    this.router.navigate(['scheduledFlight/modify']);
  }

  addFlight(): void{
    this.router.navigate(['/flight/addnewflight']);
  }

  viewFlight(): void{
    this.router.navigate(['flight']);
  }

  addAirport(): void{
    this.router.navigate(['/airport/addnewairport']);
  }

  viewAirport(): void{
    this.router.navigate(['airport']);
  }
  

}