import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PreguntaDetailComponent } from './pregunta-detail.component';

describe('PreguntaDetailComponent', () => {
  let component: PreguntaDetailComponent;
  let fixture: ComponentFixture<PreguntaDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PreguntaDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PreguntaDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
