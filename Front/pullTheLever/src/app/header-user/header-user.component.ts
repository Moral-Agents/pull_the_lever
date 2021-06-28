import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { Router } from "@angular/router";
@Component({
  selector: 'app-header-user',
  templateUrl: './header-user.component.html',
  styleUrls: ['./header-user.component.css']
})
export class HeaderUserComponent implements OnInit {

  constructor(private RestService:RestService,private router: Router) { }

  ngOnInit(): void {
  }

  public logout(){
    localStorage.removeItem("accessToken");
    this.router.navigate(["../game"])
    window.location.reload()
  }
}
