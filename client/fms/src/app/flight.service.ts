import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Flight } from './flight';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  updateFlight(flightNo: any, flight: Flight) : Observable<any> {
    return this.httpClient.put(`${this.baseUrl}/${flightNo}`, flight);
  }
  
  getFlightById(flightNo: number)  :Observable<Flight>
  {
    return this.httpClient.get<Flight>('${this.baseUrl}/${flightNo}');
   
  }
  createFlight(flight: Flight):Observable<Object>
  {
   return this.httpClient.post(`${this.baseUrl2}`,flight);
  }
  deleteFlight(id: number) :Observable<any>
  {
   return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
  getFlightsList():Observable<Flight[]>
  {
    return this.httpClient.get<Flight[]>(`${this.baseUrl}`);
  }
  private baseUrl = 'http://localhost:8082/flight';
  private baseUrl2= 'http://localhost:8082/flight/addnewflight'

  constructor(private httpClient:HttpClient) { }
}
