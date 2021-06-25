import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContribuirComponent } from './contribuir.component';

describe('ContribuirComponent', () => {
  let component: ContribuirComponent;
  let fixture: ComponentFixture<ContribuirComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContribuirComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContribuirComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
