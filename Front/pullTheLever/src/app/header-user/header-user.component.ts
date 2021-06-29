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
    if(localStorage.getItem("accessToken") == null){
      this.router.navigateByUrl("/game");
    }
  }

  public logout(){
    localStorage.removeItem("accessToken");
    localStorage.removeItem("userEmail");
    localStorage.removeItem("userPassword");
    this.router.navigateByUrl("/game");
    window.location.reload()
  }
}
