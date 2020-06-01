import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PortailCytoyensComponent } from './portail-cytoyens.component';

describe('PortailCytoyensComponent', () => {
  let component: PortailCytoyensComponent;
  let fixture: ComponentFixture<PortailCytoyensComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PortailCytoyensComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PortailCytoyensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
