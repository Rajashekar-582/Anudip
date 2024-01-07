import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from './booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  getBooking(bookingId: number): Observable<Booking> {
    return this.httpClient.get<Booking>(`${this.baseUrl}/${bookingId}`);
  }
  addBooking(booking: Booking) {
    return this.httpClient.post(`${this.baseUrl2}`,booking);
  }
  deleteBooking(id: number):Observable<any>
  {
   return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
  getBookingsList():Observable<Booking[]>
  {
    return this.httpClient.get<Booking[]>(`${this.baseUrl}`);
  }

  private baseUrl = 'http://localhost:8082/booking';
  private baseUrl2="http://localhost:8082/booking/addnewbooking";
  

  constructor(private httpClient:HttpClient) { }
}
