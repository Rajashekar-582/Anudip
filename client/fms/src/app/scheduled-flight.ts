import { Flight } from "./flight";
import { Schedule } from "./schedule";

export class ScheduledFlight {
    scheduleFlightId!: number;
    flight!: Flight;
    availableSeats!: number;
    schedule!: Schedule;
}
