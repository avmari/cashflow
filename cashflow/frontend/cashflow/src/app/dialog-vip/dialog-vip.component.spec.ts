import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogVipComponent } from './dialog-vip.component';

describe('DialogVipComponent', () => {
  let component: DialogVipComponent;
  let fixture: ComponentFixture<DialogVipComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogVipComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogVipComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
