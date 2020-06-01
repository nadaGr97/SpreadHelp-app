import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidatutreComponent } from './candidatutre.component';

describe('CandidatutreComponent', () => {
  let component: CandidatutreComponent;
  let fixture: ComponentFixture<CandidatutreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CandidatutreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CandidatutreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
