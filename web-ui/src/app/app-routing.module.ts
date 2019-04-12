import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegisterComponent } from './register/register.component';
import { PasswordChangeComponent } from './password-change/password-change.component';
import { RegisterAccountComponent } from './register-account/register-account.component';
import { HeaderComponent } from './header/header.component';
import { QuestionComponent } from './question/question.component';
import { ChatPageComponent } from './chat-page/chat-page.component';
import { TaskComponent } from './task/task.component';

const routes: Routes = [
  { path: '', redirectTo: '/account/login', pathMatch: 'full' },
  { path: 'account', component: HeaderComponent, children: [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: LoginPageComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'password', component: PasswordChangeComponent },
    { path: 'question', component: QuestionComponent }
  ]},
  { path: 'chat', component: ChatPageComponent },
  { path: 'task', component: TaskComponent}
];

@NgModule({
  imports: [
      CommonModule,
      RouterModule.forRoot(routes)
    ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
