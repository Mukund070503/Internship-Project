import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamBySIdComponent } from './team-by-sid.component';

describe('TeamBySIdComponent', () => {
  let component: TeamBySIdComponent;
  let fixture: ComponentFixture<TeamBySIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TeamBySIdComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TeamBySIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
