import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-booking-confirmed',
  templateUrl: './booking-confirmed.component.html',
  styleUrls: ['./booking-confirmed.component.css']
})
export class BookingConfirmedComponent implements OnInit {
  confirmationData: any; // You can replace 'any' with a more specific type based on your data structure

  constructor() { }

  ngOnInit(): void {
    // Example data (replace this with actual API call or data retrieval logic)
    this.confirmationData = {
      bookingId: '12345',
      flightNumber: 'F123',
      source: 'City A',
      destination: 'City B',
      departureTime: '2024-01-05 12:00 PM',
      arrivalTime: '2024-01-05 02:00 PM',
      passengers: [
        { pnr: 'ABC123', name: 'John Doe', age: 30, gender: 'Male', id: 'ID123' },
        // Add more passenger details as needed
      ],
      contactNumber: '123-456-7890',
      billingAddress: '123 Main St, City C',
      year: '2024',
    };
  }
}
