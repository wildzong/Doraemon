import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  dropdown = 'All';

  constructor() { }

  ngOnInit() {
  }

  changeSearch(id) {
    console.log(id);
    this.dropdown = document.getElementById(id).innerHTML;
  }

}
