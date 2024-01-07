import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {
  constructor(private flightService:FlightService,private router:Router)
  {


  }
   flight:Flight[]=[];
   
   
   ngOnInit():void
   {
    this.getFlights();
   }
   


   private getFlights()
   {
      this.flightService.getFlightsList().subscribe(data=>
        {
          this.flight=data;
        });
   }
   updateFlight(id:number)
   {
    this.router.navigate(['flight',id]);
   }
   deleteFlight(id:number):void
   {
    this.flightService.deleteFlight(id).subscribe(data=>
      {
        console.log(data);
       this.getFlights();
      }
      )
   }
}



