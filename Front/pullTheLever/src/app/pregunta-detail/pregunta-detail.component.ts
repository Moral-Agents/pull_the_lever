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
  public form!: FormGroup
  public pregunta:any
  constructor(private route:ActivatedRoute, private formBuilder: FormBuilder, private RestService:RestService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe( (paramMap:any) => {
      const{params} = paramMap;
      this.getData(params.id)
    })
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

  getData(id:string){
    this.RestService.get(`https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/preguntas/${id}`)
    .subscribe(response => {
      this.pregunta = JSON.parse(JSON.stringify(response)).data;
      console.log(this.pregunta)
    })
  }

}
