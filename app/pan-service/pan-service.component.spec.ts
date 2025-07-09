import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanServiceComponent } from './pan-service.component';

describe('PanServiceComponent', () => {
  let component: PanServiceComponent;
  let fixture: ComponentFixture<PanServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PanServiceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PanServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
