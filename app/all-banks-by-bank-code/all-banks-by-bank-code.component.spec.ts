import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllBanksByBankCodeComponent } from './all-banks-by-bank-code.component';

describe('AllBanksByBankCodeComponent', () => {
  let component: AllBanksByBankCodeComponent;
  let fixture: ComponentFixture<AllBanksByBankCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllBanksByBankCodeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllBanksByBankCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
