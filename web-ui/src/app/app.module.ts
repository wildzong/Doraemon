import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { HeaderComponent } from './header/header.component';
import { RegisterComponent } from './register/register.component';
import { PasswordChangeComponent } from './password-change/password-change.component';
import { RegisterAccountComponent } from './register-account/register-account.component';
import { QuestionComponent } from './question/question.component';
import { ChatPageComponent } from './chat-page/chat-page.component';
import { TaskComponent } from './task/task.component';
import { FormsModule } from '@angular/forms';
import { MessageSendComponent } from './message-send/message-send.component';
import { MessageReceiveComponent } from './message-receive/message-receive.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    HeaderComponent,
    RegisterComponent,
    PasswordChangeComponent,
    RegisterAccountComponent,
    QuestionComponent,
    ChatPageComponent,
    TaskComponent,
    MessageSendComponent,
    MessageReceiveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
