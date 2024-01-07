import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule,HttpClient } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { RouterModule } from '@angular/router';
import { CreateUserComponent } from './create-user/create-user.component';
import { FormsModule } from '@angular/forms';
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
import { WelcomeAdminComponent } from './welcome-admin/welcome-admin.component';
import { AdminpanelComponent } from './adminpanel/adminpanel.component';

import { SignupComponent } from './signup/signup.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { BookingConfirmedComponent } from './booking-confirmed/booking-confirmed.component';
import { HomepageComponent } from './homepage/homepage.component';



@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    CreateUserComponent,
    UpdateUserComponent,
    AirportListComponent,
    CreateAirportComponent,
    UpdateAirportComponent,
    FlightListComponent,
    CreateFlightComponent,
    UpdateFlightComponent,
    BookingListComponent,
    CreateBookingComponent,
    
    NavbarComponent,
    AddScheduledComponent,
    HomeComponent,
    LoginComponent,
    UserpanelComponent,
    WelcomeAdminComponent,
    AdminpanelComponent,
    
    SignupComponent,
    UserDetailsComponent,
    BookingConfirmedComponent,
    HomepageComponent,
   
   
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
