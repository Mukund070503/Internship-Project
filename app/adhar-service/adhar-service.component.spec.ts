import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdharServiceComponent } from './adhar-service.component';

describe('AdharServiceComponent', () => {
  let component: AdharServiceComponent;
  let fixture: ComponentFixture<AdharServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdharServiceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdharServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
