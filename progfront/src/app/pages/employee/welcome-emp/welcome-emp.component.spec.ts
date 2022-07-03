import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WelcomeEmpComponent } from './welcome-emp.component';

describe('WelcomeEmpComponent', () => {
  let component: WelcomeEmpComponent;
  let fixture: ComponentFixture<WelcomeEmpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WelcomeEmpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WelcomeEmpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
