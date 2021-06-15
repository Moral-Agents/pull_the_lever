import { Component, OnInit } from '@angular/core';
import { RestService } from "../rest.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {
  public form!: FormGroup;
  constructor(private RestService:RestService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    // Si hay error de control access habilitar CORS
    this.readComentarios();
    this.form = this.formBuilder.group({
      text:['']
    })
  }

  public createComentarios() {
    this.RestService.post('https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/comentarios',
      {
        comentario: this.form.value.text,
        preguntaId: "1",
        usuarioId: "1"
      }
    )
      .subscribe(respuesta => {
        console.log("Success");
      })
  }

  public readComentarios() {
    this.RestService.get('https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/comentarios/1')
      .subscribe(response => {
        console.log(response);
      })
  }
}
