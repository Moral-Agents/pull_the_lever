import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
@Component({
  selector: 'app-header-user',
  templateUrl: './header-user.component.html',
  styleUrls: ['./header-user.component.css']
})
export class HeaderUserComponent implements OnInit {

  constructor(private RestService:RestService) { }

  ngOnInit(): void {
  }

  public logout(){
    localStorage.removeItem("accessToken");
    window.location.reload();
  }
}
