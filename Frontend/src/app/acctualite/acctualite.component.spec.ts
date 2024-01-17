import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcctualiteComponent } from './acctualite.component';

describe('AcctualiteComponent', () => {
  let component: AcctualiteComponent;
  let fixture: ComponentFixture<AcctualiteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AcctualiteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AcctualiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
