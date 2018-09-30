import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SacComponent } from './sac.component';

describe('SacComponent', () => {
  let component: SacComponent;
  let fixture: ComponentFixture<SacComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SacComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SacComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
