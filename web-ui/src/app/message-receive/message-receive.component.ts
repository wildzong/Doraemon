import { Component, OnInit, Input } from '@angular/core';
import { Message } from '../data';

@Component({
  selector: 'app-message-receive',
  templateUrl: './message-receive.component.html',
  styleUrls: ['./message-receive.component.css']
})
export class MessageReceiveComponent implements OnInit {
  @Input() receive: Message;

  constructor() { }

  ngOnInit() {
  }

}
