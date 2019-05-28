import { Component, OnInit } from '@angular/core';
import { Task } from '../data';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  // dropdown controls the search switch
  dropdown = 'All';

  // keyValue stores the search key words
  keyValue = '';

  taskTodo: Task[] = [
    {Name: 'task 1', Content: 'this is test 1', State: '1'},
    {Name: 'task 2', Content: 'this is test 2', State: '1'},
  ];
  taskDoing: Task[] = [
    {Name: 'task 3', Content: 'this is test 3', State: '2'},
    {Name: 'task 4', Content: 'this is test 4', State: '2'}
  ];
  taskDone: Task[] = [
    {Name: 'task 5', Content: 'this is test 5', State: '3'},
    {Name: 'task 6', Content: 'this is test 6', State: '3'},
  ];
  taskDelete: Task[] = [
    {Name: 'task 7', Content: 'this is test 7', State: '4'},
    {Name: 'task 8', Content: 'this is test 8', State: '4'},
    {Name: 'task 9', Content: 'this is test 9', State: '4'}
  ];

  // task-Display is the data that displayed in the web
  taskTodoDisplay = this.taskTodo;
  taskDoingDisplay = this.taskDoing;
  taskDoneDisplay = this.taskDone;
  taskDeleteDisplay = this.taskDelete;

  // these length is used to display the number
  todoLength: number = this.taskTodoDisplay.length;
  doingLength: number = this.taskDoingDisplay.length;
  doneLength: number = this.taskDoneDisplay.length;
  deleteLength: number = this.taskDeleteDisplay.length;

  // addTask is used to control the model
  addTask = false;

  // TaskAdd is used to add task to taskTodoDisplay
  TaskAdd: Task = {
    Name: '',
    Content: '',
    State: '1',
  };

  constructor() { }

  ngOnInit() {

  }

  // tslint:disable-next-line:use-life-cycle-interface
  ngAfterContentChecked(): void {
    // Called after every check of the component's or directive's content.
    // Add 'implements AfterContentChecked' to the class.
    if (this.taskTodoDisplay === null) {
      this.todoLength = 0;
    } else {
      this.todoLength = this.taskTodoDisplay.length;
    }

    if (this.taskDoingDisplay === null) {
      this.doingLength = 0;
    } else {
      this.doingLength = this.taskDoingDisplay.length;
    }

    if (this.taskDoneDisplay === null) {
      this.doneLength = 0;
    } else {
      this.doneLength = this.taskDoneDisplay.length;
    }

    if (this.taskDeleteDisplay === null) {
      this.deleteLength = 0;
    } else {
      this.deleteLength = this.taskDeleteDisplay.length;
    }

    if (this.keyValue === '') {
      this.taskTodoDisplay = this.taskTodo;
      this.taskDoingDisplay = this.taskDoing;
      this.taskDoneDisplay = this.taskDone;
      this.taskDeleteDisplay = this.taskDelete;
    }
  }

  changeSearch(id) {
    this.dropdown = document.getElementById(id).innerHTML;
  }

  TodoToDel(obj: any) {
    console.log(obj);
    for (let i = 0; i < this.taskTodoDisplay.length; i++) {
      if (this.taskTodoDisplay[i] === obj) {
        this.taskTodoDisplay.splice(i, 1);
      }
    }
    this.taskDeleteDisplay.push(obj);
  }

  TodoToDoing(obj: any) {
    for (let i = 0; i < this.taskTodoDisplay.length; i++) {
      if (this.taskTodoDisplay[i] === obj) {
        this.taskTodoDisplay.splice(i, 1);
      }
    }
    this.taskDoingDisplay.push(obj);
  }

  DoingToDel(obj: any) {
    for (let i = 0; i < this.taskDoingDisplay.length; i++) {
      if (this.taskDoingDisplay[i] === obj) {
        this.taskDoingDisplay.splice(i, 1);
      }
    }
    this.taskDeleteDisplay.push(obj);
  }

  DoingToDone(obj: any) {
    for (let i = 0; i < this.taskDoingDisplay.length; i++) {
      if (this.taskDoingDisplay[i] === obj) {
        this.taskDoingDisplay.splice(i, 1);
      }
    }
    this.taskDoneDisplay.push(obj);
  }

  DoneToDel(obj: any) {
    for (let i = 0; i < this.taskDoneDisplay.length; i++) {
      if (this.taskDoneDisplay[i] === obj) {
        this.taskDoneDisplay.splice(i, 1);
      }
      this.taskDeleteDisplay.push(obj);
    }
  }

  DelToNone(obj: any) {
    for (let i = 0; i < this.taskDeleteDisplay.length; i++) {
      if (this.taskDeleteDisplay[i] === obj) {
        this.taskDeleteDisplay.splice(i, 1);
      }
    }
  }

  openModel() {
    this.addTask = true;
  }

  closeModel() {
    this.addTask = false;
  }

  confirmTask() {
    console.log(this.TaskAdd);
    this.taskTodoDisplay.push(this.TaskAdd);
    this.addTask = false;
  }

  searchTask() {
    const key = this.keyValue;
    console.log(key);
    const that = this;
    if (this.dropdown === 'Todo') {
      this.taskTodoDisplay = this.search(key, that.taskTodo);
    } else if (this.dropdown === 'Doing') {
      this.taskDoingDisplay = this.search(key, that.taskDoing);
    } else if (this.dropdown === 'Closed') {
      this.taskDoneDisplay = this.search(key, that.taskDone);
    } else if (this.dropdown === 'Deleted') {
      this.taskDeleteDisplay = this.search(key, that.taskDelete);
    } else if (this.dropdown === 'All') {
      this.taskTodoDisplay = this.search(key, that.taskTodo);
      this.taskDoingDisplay = this.search(key, that.taskDoing);
      this.taskDoneDisplay = this.search(key, that.taskDone);
      this.taskDeleteDisplay = this.search(key, that.taskDelete);
    }
  }

  search(key: string, arr: Task[]) {
    let arr2: Task[] = null;
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < arr.length; i++) {
      if (arr[i].Name.indexOf(key) >= 0) {
        arr2 = arr2 || [];
        arr2.push(arr[i]);
      }
    }

    console.log(arr2);

    return arr2;
  }
}
