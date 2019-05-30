import { Component, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { User, Message } from '../data';
import { MessageSendComponent } from '../message-send/message-send.component';
import { MessageReceiveComponent } from '../message-receive/message-receive.component';

@Component({
  selector: 'app-chat-page',
  templateUrl: './chat-page.component.html',
  styleUrls: ['./chat-page.component.css']
})

export class ChatPageComponent implements OnInit {

  user: User = {
    HeadProfile: '../../assets/4.jpg',
    Name: '阿汤',
    Friends: [
      {HeadProfile: '../../assets/2.jpg', Name: 'superpants', Friends: null, HistoryChat: null, LastChatTime: null},
      {HeadProfile: '../../assets/3.jpg', Name: 'wildzong', Friends: null, HistoryChat: null, LastChatTime: null},
      {HeadProfile: '../../assets/1.jpg', Name: 'Marzzy', Friends: null, HistoryChat: null, LastChatTime: null}
    ],
    HistoryChat: [
      {HeadProfile: '../../assets/3.jpg', Name: 'wildzong', Friends: null, HistoryChat: null, LastChatTime: '21:54'}
    ],
    LastChatTime: null
  };

  // userChat is used to control the user you talk to.
  userChat: User = {
    HeadProfile: '',
    Name: '',
    Friends: null,
    HistoryChat: null,
    LastChatTime: null
  };

  // ifHistory and ifFriends used to switch the bar
  ifHistory = true;
  ifFriends = false;

  // ifChat controls the chat panel
  ifChat = false;

  // msgArray used to store msg
  msgArray: Message[] = [
    {UserChat: this.user, Text: 'hello', Type: true}
  ];

  // msgSend used to send msg
  msgSend: Message = null;

  // message is used to receive the msg you send
  message = '';

  constructor() { }

  ngOnInit() {
  }

  changeHistory() {
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

  openChat(user: User) {
    this.ifChat = true;
    this.userChat = user;
  }

  // sendMsg is used to send msg
  sendMsg() {
    if (this.message !== '') {
      console.log(this.userChat);
      this.msgSend = {
        UserChat: this.user,
        Text: this.message,
        Type: true,
      };
      this.message = '';
      this.msgArray.push(this.msgSend);
    } else {

    }
  }
}
