import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.css']
})
export class PlansComponent implements OnInit {
  public userId: any
  constructor() { }

  ngOnInit(): void {
    this.userId = localStorage.getItem("accessToken");
  }

}
