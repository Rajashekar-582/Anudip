import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { Airport } from './airport';
@Injectable({
  providedIn: 'root'
})
export class AirportService {
  getAllAirports() :Observable<Airport[]>
  {
    return this.httpClient.get<Airport[]>(`${this.baseUrl}`);
  }
  viewAirport(airportCode: string) {
    const viewUrl = `${this.baseUrl}/${airportCode}`;

  // Send a GET request to retrieve the airport details
  return this.httpClient.get<Airport>(viewUrl);
  }
  updateAirport(airportCode: string, airport: Airport) {
    return this.httpClient.get<Airport>('${this.baseUrl}/${Id}');
  }
  addAirport(airport: Airport) {
    return this.httpClient.post(`${this.baseUrl2}`,airport);
  }
  deleteAirport(id: number):Observable<any>
  {
   return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }
  getAirportsList() :Observable<Airport[]>
  {
    return this.httpClient.get<Airport[]>(`${this.baseUrl}`);
  }
  getAirportById(Id: number) :Observable<Airport>
  {
    return this.httpClient.get<Airport>('${this.baseUrl}/${Id}');
   
  }
  private baseUrl = 'http://localhost:8082/airport';
  private baseUrl2="http://localhost:8082/airport/addnewairport";
  

  constructor(private httpClient:HttpClient) { }
}
