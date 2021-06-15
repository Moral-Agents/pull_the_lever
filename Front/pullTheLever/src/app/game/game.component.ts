import { Component, OnInit } from '@angular/core';
import { RestService } from "../rest.service";

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  constructor(private RestService:RestService) { }

  ngOnInit(): void {
    // Si hay error de control access habilitar CORS
    this.readComentarios();
  }

  public readComentarios() {
    this.RestService.get('http://shibe.online/api/shibes?count=1&urls=true&httpsUrls=true')
      .subscribe(response => {
        console.log(response);
      })
  }
}
