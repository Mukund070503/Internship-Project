import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReloadTeamComponent } from './reload-team.component';

describe('ReloadTeamComponent', () => {
  let component: ReloadTeamComponent;
  let fixture: ComponentFixture<ReloadTeamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ReloadTeamComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReloadTeamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
