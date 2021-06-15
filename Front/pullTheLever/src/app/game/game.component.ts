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
  public listPreguntas:any = {}
  constructor(private RestService:RestService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    // Si hay error de control access habilitar CORS
    this.readPreguntas();
    this.form = this.formBuilder.group({
      text:['']
    })
  }


  public readPreguntas() {
    this.RestService.get('https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/preguntas')
      .subscribe(response => {
        this.listPreguntas = JSON.parse(JSON.stringify(response)).data;
        console.log(response);

      })
  }

}
