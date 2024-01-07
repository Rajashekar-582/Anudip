import { Component, OnInit } from '@angular/core';
import { ScheduledFlight } from '../scheduled-flight';
import { ScheduledFlightService } from '../scheduled-flight.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Schedule } from '../schedule';
import { Flight } from '../flight';

@Component({
  selector: 'app-add-scheduled',
  templateUrl: './add-scheduled.component.html',
  styleUrls: ['./add-scheduled.component.css']
})
export class AddScheduledComponent implements OnInit {

  srcAirport!: string;
  dstnAirport!: string;
  deptDateTime!: string;
  arrDateTime!: string;

  scheduleFlight: ScheduledFlight = {
    scheduleFlightId: 0,
    availableSeats: 0,
    flight: new Flight(),
    schedule: new Schedule()
  };

  idValid: boolean = false;

  constructor(private scheduleFlightService: ScheduledFlightService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {}

  addScheduleFlight(sa: string, da: string, ddt: string, adt: string) {
    this.srcAirport = sa;
    this.dstnAirport = da;
    this.deptDateTime = ddt;
    this.arrDateTime = adt;
  
    const scheduleFlight: ScheduledFlight = {
      scheduleFlightId: 0,
      availableSeats: 0,
      flight: new Flight(),
      schedule: new Schedule()
    };
  
    this.scheduleFlightService.addScheduleFlight(scheduleFlight, sa, da, ddt, adt).subscribe(() => {
      alert("Schedule Flight added");
    });
  }
  

  validateId() {
    if (this.scheduleFlight.scheduleFlightId > 999) {
      this.idValid = true;
    } else if (this.scheduleFlight.scheduleFlightId < 1) {
      this.idValid = true;
    } else {
      this.idValid = false;
    }
  }

  validateAirports(a: string, b: string) {
    if (a.toLowerCase() === b.toLowerCase()) {
      this.airportValid = true;
    } else {
      this.airportValid = false;
    }
    this.enableButton();
  }

  airportValid: boolean = false;

  enableButton() {
    this.buttonFlag = !this.idValid && !this.airportValid;
  }

  buttonFlag: boolean = false;

  add() {
    this.router.navigate(['/scheduledFlight/add']);
  }

  view() {
    this.router.navigate(['/scheduledFlight/show']);
  }

  search() {
    this.router.navigate(['/scheduledFlight/search']);
  }
}
