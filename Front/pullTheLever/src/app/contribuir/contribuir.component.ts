import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from "@angular/forms";
@Component({
  selector: 'app-contribuir',
  templateUrl: './contribuir.component.html',
  styleUrls: ['./contribuir.component.css']
})
export class ContribuirComponent implements OnInit {
  public userId:any;
  public form!: FormGroup;
  constructor() { }

  ngOnInit(): void {
    this.userId = localStorage.getItem("accessToken");
  }

}
