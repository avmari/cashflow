import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSphereComponent } from './create-sphere.component';

describe('CreateSphereComponent', () => {
  let component: CreateSphereComponent;
  let fixture: ComponentFixture<CreateSphereComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateSphereComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSphereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
