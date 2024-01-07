import { Component, OnInit } from '@angular/core';
import { BookingService } from '../booking.service';
import { Booking } from '../booking';
import { Router } from '@angular/router';

@Component({
  selector: 'app-booking-list',
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent implements OnInit {
  constructor(private bookingService:BookingService,private router:Router)
  {


  }
   booking:Booking[]=[];
   
   
   ngOnInit():void
   {
    this.getBookings();
   }
   bookingDetails(bookingId: number) {
    // Implement the logic to navigate to the details page
    this.router.navigate(['/booking-details', bookingId]);
  }

   private getBookings()
   {
      this.bookingService.getBookingsList().subscribe(data=>
        {
          this.booking=data;
        });
   }
   updateBooking(id:number)
   {
    this.router.navigate(['booking',id]);
   }
   deleteBooking(id:number):void
   {
    this.bookingService.deleteBooking(id).subscribe(data=>
      {
        console.log(data);
       this.getBookings();
      }
      )
   }
}




