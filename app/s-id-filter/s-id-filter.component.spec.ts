import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SIdFilterComponent } from './s-id-filter.component';

describe('SIdFilterComponent', () => {
  let component: SIdFilterComponent;
  let fixture: ComponentFixture<SIdFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SIdFilterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SIdFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
