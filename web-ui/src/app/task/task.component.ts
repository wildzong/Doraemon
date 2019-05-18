import { Component, OnInit } from '@angular/core';
import { Task } from '../data';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  dropdown = 'All';

  taskTodo: Task[] = [
    {Name: 'task 1', Content: 'this is test 1', State: '1'},
    {Name: 'task 2', Content: 'this is test 2', State: '1'},
  ];
  taskDoing: Task[] = [
    {Name: 'task 3', Content: 'this is test 3', State: '2'},
    {Name: 'task 4', Content: 'this is test 4', State: '2'}
  ];
  taskDone: Task[] = [
    {Name: 'task 5', Content: 'this is test 2', State: '3'},
    {Name: 'task 6', Content: 'this is test 3', State: '3'},
  ];
  taskDelete: Task[] = [
    {Name: 'task 7', Content: 'this is test 2', State: '4'},
    {Name: 'task 8', Content: 'this is test 3', State: '4'},
    {Name: 'task 9', Content: 'this is test 4', State: '4'}
  ];

  todoLength: number = this.taskTodo.length;
  doingLength: number = this.taskDoing.length;
  doneLength: number = this.taskDone.length;
  deleteLength: number = this.taskDelete.length;

  constructor() { }

  ngOnInit() {

  }

  ngAfterContentChecked(): void {
    //Called after every check of the component's or directive's content.
    //Add 'implements AfterContentChecked' to the class.
    this.todoLength = this.taskTodo.length;
    this.doingLength = this.taskDoing.length;
    this.doneLength = this.taskDone.length;
    this.deleteLength = this.taskDelete.length;
  }

  changeSearch(id) {
    this.dropdown = document.getElementById(id).innerHTML;
  }

  TodoToDel(obj: any) {
    console.log(obj);
    for (let i = 0; i < this.taskTodo.length; i++) {
      if (this.taskTodo[i] === obj) {
        this.taskTodo.splice(i, 1);
      }
    }
    this.taskDelete.push(obj);
  }

  TodoToDoing(obj: any) {
    for (let i = 0; i < this.taskTodo.length; i++) {
      if (this.taskTodo[i] === obj) {
        this.taskTodo.splice(i, 1);
      }
    }
    this.taskDoing.push(obj);
  }

  DoingToDel(obj: any) {
    for (let i = 0; i < this.taskDoing.length; i++) {
      if (this.taskDoing[i] === obj) {
        this.taskDoing.splice(i, 1);
      }
    }
    this.taskDelete.push(obj);
  }

  DoingToDone(obj: any) {
    for (let i = 0; i < this.taskDoing.length; i++) {
      if (this.taskDoing[i] === obj) {
        this.taskDoing.splice(i, 1);
      }
    }
    this.taskDone.push(obj);
  }

  DoneToDel(obj: any) {
    for (let i = 0; i < this.taskDone.length; i++) {
      if (this.taskDone[i] === obj) {
        this.taskDone.splice(i, 1);
      }
      this.taskDelete.push(obj);
    }
  }

  DelToNone(obj: any) {
    for (let i = 0; i < this.taskDelete.length; i++) {
      if (this.taskDelete[i] === obj) {
        this.taskDelete.splice(i, 1);
      }
    }
  }

}
