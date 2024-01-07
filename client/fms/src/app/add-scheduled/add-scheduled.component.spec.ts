import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddScheduledComponent } from './add-scheduled.component';

describe('AddScheduledComponent', () => {
  let component: AddScheduledComponent;
  let fixture: ComponentFixture<AddScheduledComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddScheduledComponent]
    });
    fixture = TestBed.createComponent(AddScheduledComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
