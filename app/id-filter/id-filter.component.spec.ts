import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IdFilterComponent } from './id-filter.component';

describe('IdFilterComponent', () => {
  let component: IdFilterComponent;
  let fixture: ComponentFixture<IdFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [IdFilterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IdFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
