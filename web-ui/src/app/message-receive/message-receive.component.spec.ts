import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MessageReceiveComponent } from './message-receive.component';

describe('MessageReceiveComponent', () => {
  let component: MessageReceiveComponent;
  let fixture: ComponentFixture<MessageReceiveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MessageReceiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MessageReceiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
