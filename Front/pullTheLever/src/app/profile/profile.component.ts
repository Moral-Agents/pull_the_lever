import { Component, OnInit } from '@angular/core';
import { RestService } from "../rest.service";
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  public userEmail:any
  public userPassword:any
  public user:any = {}
  constructor(private RestService:RestService) { }

  ngOnInit(): void {
    this.userEmail = localStorage.getItem("userEmail");
    this.userPassword = localStorage.getItem("userPassword");
    this.getData();
  }

  getData() {
    this.RestService.get(`https://app-pull-the-lever.herokuapp.com/pull/v1/usuarios/${this.userEmail}/${this.userPassword}`)
      .subscribe(response => {
        this.user = JSON.parse(JSON.stringify(response)).data;
        console.log(this.user);
      })
  }

}
