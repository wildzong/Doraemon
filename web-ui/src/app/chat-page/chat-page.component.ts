import { Component, OnInit } from '@angular/core';
import { User } from '../data';

@Component({
  selector: 'app-chat-page',
  templateUrl: './chat-page.component.html',
  styleUrls: ['./chat-page.component.css']
})
export class ChatPageComponent implements OnInit {

  user: User = {
    HeadProfile: '../../assets/1.jpg',
    Name: '阿汤',
    Friends: [
      {HeadProfile: '../../assets/2.jpg', Name: 'superpants', Friends: null, HistoryChat: null, LastChatTime: null},
      {HeadProfile: '../../assets/3.jpg', Name: 'wildzong', Friends: null, HistoryChat: null, LastChatTime: null}
    ],
    HistoryChat: [
      {HeadProfile: '../../assets/4.jpg', Name: 'bilibili', Friends: null, HistoryChat: null, LastChatTime: '21:54'}
    ],
    LastChatTime: null
  }

  // ifHistory and ifFriends used to switch the bar
  ifHistory: boolean = true;
  ifFriends: boolean = false;

  // ifChat controls the chat panel
  ifChat: boolean = true;

  constructor() { }

  ngOnInit() {
  }

  changeHistory() {
    console.log("test");
    if (this.ifHistory !== true) {
      this.ifHistory = true;
      this.ifFriends = false;
    }
  }


  changeFriends() {
    if (this.ifFriends !== true) {
      this.ifFriends = true;
      this.ifHistory = false;
    }
  }

}
  