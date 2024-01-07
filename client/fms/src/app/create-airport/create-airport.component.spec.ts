import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAirportComponent } from './create-airport.component';

describe('CreateAirportComponent', () => {
  let component: CreateAirportComponent;
  let fixture: ComponentFixture<CreateAirportComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateAirportComponent]
    });
    fixture = TestBed.createComponent(CreateAirportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
