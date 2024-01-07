import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, map } from 'rxjs';

@Component({
  selector: 'app-update-flight',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.css']
})
export class UpdateFlightComponent implements OnInit
{
     flightNo!:number;
     flight:Flight=new Flight();
     constructor(private flightService:FlightService,private router:Router,
       private route:ActivatedRoute)
     {
  
     }

     

ngOnInit(): void {
  this.flight = new Flight();
  this.flightNo = this.route.snapshot.params['flightNo'];

  this.flightService.getFlightById(this.flightNo).pipe(
    map((data: Flight) => {
      this.flight = data;
    }),
    catchError((error: any) => {
      console.log(error);
      throw error; // Re-throw the error to propagate it further
    })
  ).subscribe();
}

      




     


    


     onSubmit()
     {
       this.updateFlight();
     }
  updateFlight() {
    throw new Error('Method not implemented.');
  }
     updateUser()
     {
       this.flightService.updateFlight(this.flightNo,this.flight).subscribe(data=>
         {this.gotoFlightList()});
     }
     gotoFlightList()
     {
       this.router.navigate(['/flight']);
     }


    
}



