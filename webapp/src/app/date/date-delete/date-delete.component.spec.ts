import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DateDeleteComponent } from './date-delete.component';

describe('DateDeleteComponent', () => {
  let component: DateDeleteComponent;
  let fixture: ComponentFixture<DateDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DateDeleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DateDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
