import { Component, OnInit } from '@angular/core';
import { Airport } from '../airport';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { AirportService } from '../airport.service';


@Component({
  selector: 'app-airport-list',
  templateUrl: './airport-list.component.html',
  styleUrls: ['./airport-list.component.css']
})
export class AirportListComponent implements OnInit
{
  constructor(private airportService:AirportService,private router:Router)
  {


  }
   airport:Airport[]=[];
   
   
   ngOnInit():void
   {
    this.getAirports();
   }
   


   private getAirports()
   {
      this.airportService.getAirportsList().subscribe(data=>
        {
          this.airport=data;
        });
   }
   updateAirport(id:number)
   {
    this.router.navigate(['airport',id]);
   }
   deleteAirport(id:number):void
   {
    this.airportService.deleteAirport(id).subscribe(data=>
      {
        console.log(data);
       this.getAirports();
      }
      )
   }
}



