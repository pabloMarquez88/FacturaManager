import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MkComponent } from './mk.component';

describe('MkComponent', () => {
  let component: MkComponent;
  let fixture: ComponentFixture<MkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MkComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
