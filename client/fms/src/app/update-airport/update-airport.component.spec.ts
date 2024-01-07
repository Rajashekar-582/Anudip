import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateAirportComponent } from './update-airport.component';

describe('UpdateAirportComponent', () => {
  let component: UpdateAirportComponent;
  let fixture: ComponentFixture<UpdateAirportComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateAirportComponent]
    });
    fixture = TestBed.createComponent(UpdateAirportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
