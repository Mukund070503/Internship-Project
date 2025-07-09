import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewBankComponent } from './new-bank.component';

describe('NewBankComponent', () => {
  let component: NewBankComponent;
  let fixture: ComponentFixture<NewBankComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewBankComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewBankComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
