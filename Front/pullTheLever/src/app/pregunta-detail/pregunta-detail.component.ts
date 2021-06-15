import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestService } from '../rest.service';
import {FormBuilder, FormGroup} from "@angular/forms";
@Component({
  selector: 'app-pregunta-detail',
  templateUrl: './pregunta-detail.component.html',
  styleUrls: ['./pregunta-detail.component.css']
})
export class PreguntaDetailComponent implements OnInit {
  public form!: FormGroup;
  public pregunta:any
  public listComentarios:any = {}
  public id:any
  constructor(private route:ActivatedRoute, private formBuilder: FormBuilder, private RestService:RestService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe( (paramMap:any) => {
      const{params} = paramMap;
      this.id = params.id;
    })
    this.getData(this.id);
    this.readComentarios(this.id);
    this.form = this.formBuilder.group({
      text:['']
    })
    this.updateComentarios("1", "PRUEBA NUEVA DESPUES");
  }

  public createComentarios() {
    this.RestService.post('https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/comentarios', {
        comentario: this.form.value.text,
        preguntaId: this.id,
        usuarioId: "1"
      }
    )
      .subscribe(respuesta => {
        console.log("Success");
      })
  }

  public readComentarios(id:string) {
    this.RestService.get(`https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/comentarios/${id}`)
      .subscribe(response => {
        this.listComentarios = JSON.parse(JSON.stringify(response)).data;
        console.log(response);
      })
  }

  public updateComentarios(id:string, comentario:string) {
    this.RestService.put(`https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/updateComentarios`, {
      id: id,
      comentario: comentario,
      preguntaId: "1",
      usuarioId: "1"
    })
      .subscribe(response => {
        console.log(response);
      })
  }

  getData(id:string){
    this.RestService.get(`https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/preguntas/${id}`)
    .subscribe(response => {
      this.pregunta = JSON.parse(JSON.stringify(response)).data;
      console.log(this.pregunta)
    })
  }
}
