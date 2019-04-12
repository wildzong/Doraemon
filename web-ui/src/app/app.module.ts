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
    TaskComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
