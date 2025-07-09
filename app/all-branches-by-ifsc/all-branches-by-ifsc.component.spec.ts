import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllBranchesByIfscComponent } from './all-branches-by-ifsc.component';

describe('AllBranchesByIfscComponent', () => {
  let component: AllBranchesByIfscComponent;
  let fixture: ComponentFixture<AllBranchesByIfscComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllBranchesByIfscComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllBranchesByIfscComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
