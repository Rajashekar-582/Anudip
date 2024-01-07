import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { AirportListComponent } from './airport-list/airport-list.component';
import { CreateAirportComponent } from './create-airport/create-airport.component';
import { UpdateAirportComponent } from './update-airport/update-airport.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { CreateFlightComponent } from './create-flight/create-flight.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { BookingListComponent } from './booking-list/booking-list.component';
import { CreateBookingComponent } from './create-booking/create-booking.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AddScheduledComponent } from './add-scheduled/add-scheduled.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UserpanelComponent } from './userpanel/userpanel.component';
import { AdminpanelComponent } from './adminpanel/adminpanel.component';
import { SignupComponent } from './signup/signup.component';
import { BookingConfirmedComponent } from './booking-confirmed/booking-confirmed.component';
import { WelcomeAdminComponent } from './welcome-admin/welcome-admin.component';
import { HomepageComponent } from './homepage/homepage.component';

const routes: Routes = [
  {path:'users',component:UserListComponent},
  {path:'signup',component:CreateUserComponent},
  {path:'users/:id',component:UpdateUserComponent},
  {path:'airport',component:AirportListComponent},
  {path:'airport/addnewairport',component:CreateAirportComponent},
  {path:'airport/:id',component:UpdateAirportComponent},
  {path:'flight',component:FlightListComponent},
  {path:'flight/addnewflight',component:CreateFlightComponent},
  {path:'flight/:flightNo',component:UpdateFlightComponent},
  {path:'booking',component:BookingListComponent},
  {path:'booking/addnewbooking',component:CreateBookingComponent},
  { path: 'navbar', component: NavbarComponent},
  { path: 'welcome', component: WelcomeAdminComponent },
  { path: 'scheduled/add', component: AddScheduledComponent },
  {path:'booking/details',component:BookingConfirmedComponent},
  {path:'home',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'userpanel',component:UserpanelComponent},
  {path:'adminpanel',component:AdminpanelComponent},
  {path:'',component:HomepageComponent},
  {path:'khgdgsh',component:SignupComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [
  WelcomeAdminComponent
  ]