/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { MainappComponent } from './mainapp.component';

describe('MainappComponent', () => {
  let component: MainappComponent;
  let fixture: ComponentFixture<MainappComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainappComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainappComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
