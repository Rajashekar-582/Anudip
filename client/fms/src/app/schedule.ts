import { Airport } from "./airport";

export class Schedule {
    scheduleId!: number;
    srcAirport!: Airport;
    dstnAirport!: Airport;
    deptDateTime!: string;
    arrDateTime!: string;
}
