import { Injectable } from '@angular/core';
import { ScheduledFlight } from './scheduled-flight';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ScheduledFlightService {
  searchScheduledFlight({ scheduleFlightId }: { scheduleFlightId: number }): Observable<ScheduledFlight> {
    return this.http.get<ScheduledFlight>('http://localhost:8082/scheduledFlight/search?flightId=' + scheduleFlightId);
  }
  
  
  constructor(private http: HttpClient) { 
  }

  addScheduleFlight(scheduleFlight: ScheduledFlight, srcAirport: string, dstnAirport: string, deptDateTime: string, arrDateTime: string) {
    let form = new FormData();
  
    // Append properties of ScheduledFlight
    form.append('scheduleFlightId', String(scheduleFlight.scheduleFlightId));
    form.append('availableSeats', String(scheduleFlight.availableSeats));
  
    // Convert and append the 'flight' and 'schedule' objects to strings
    form.append('flight', JSON.stringify(scheduleFlight.flight));
    form.append('schedule', JSON.stringify(scheduleFlight.schedule));
  
    let params = new HttpParams()
      .set('srcAirport', srcAirport)
      .set('dstnAirport', dstnAirport)
      .set('deptDateTime', deptDateTime)
      .set('arrDateTime', arrDateTime);
  
    console.log(scheduleFlight);
    console.log(params.toString());
    // console.log(form);
  
    return this.http.post('http://localhost:8082/scheduledflight/addnewone', form, { params });
  }

  getByScheduleFlight(scheduledFlightId: number) {
    return this.http.get('http://localhost:8082/scheduledflight/${scheduledflightId}');
  }

  getScheduleFlights(): Observable<any> {
    return this.http.get('http://localhost:8082/scheduledflight');
  }

  deleteScheduleFlight(scheduleflightId:number){
    return this.http.delete('http://localhost:8082/scheduledflight/${scheduleflightId}');
 }

 modifyScheduleFlight(scheduledFlight:ScheduledFlight){
   let mForm= new FormData();
   mForm.append("scheduleFlightId",String(scheduledFlight.scheduleFlightId))
   mForm.append("schedule",String(scheduledFlight.schedule))
   mForm.append("flight",String(scheduledFlight.flight))
   mForm.append("availableSeats",String(scheduledFlight.availableSeats))
   return this.http.put('http://localhost:8082/scheduledFlight/modify?',mForm);
 }

}
