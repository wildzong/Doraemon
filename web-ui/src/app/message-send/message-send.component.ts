import { Component, OnInit, Input, Directive, ViewContainerRef } from '@angular/core';
import { Message } from '../data';

@Component({
  selector: 'app-message-send',
  templateUrl: './message-send.component.html',
  styleUrls: ['./message-send.component.css']
})
export class MessageSendComponent implements OnInit {
  @Input() send: Message;

  constructor() { }

  ngOnInit() {
  }

}
