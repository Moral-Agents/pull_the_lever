import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RestService } from '../rest.service';
import { FormBuilder, FormGroup } from "@angular/forms";
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
  public key:any
  public respuesta:any
  public userId:any
  accion:boolean = false

  constructor(private route:ActivatedRoute, private formBuilder: FormBuilder, private RestService:RestService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe( (paramMap:any) => {
      const{params} = paramMap;
      this.id = params.id;
    })
    this.getData(this.id);
    this.readComentarios(this.id);
    this.userId = localStorage.getItem("accessToken");
    this.form = this.formBuilder.group({
      text:[''],
      textUpdate:['']
    })

  }

  public createComentarios() {
    this.RestService.post('https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/comentarios', {
        comentario: this.form.value.text,
        fecha_creacion: "2021-06-19T19:43:32.713Z",
        preguntaId: this.id,
        usuarioId: this.userId
      }
    )
      .subscribe(respuesta => {
        console.log("Success");
        this.readComentarios(this.id);
      })
  }

  public createRespuesta(){
    this.RestService.post('https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/respuestas',{
      preguntaId:Number(this.id),
      respuesta: Number(this.respuesta),
      usuarioId: this.userId
    }).subscribe(res => {
      console.log("Success");
      
    })
  }

  public readComentarios(id:string) {
    let inputPost = document.getElementById("inputPost") as HTMLInputElement;
    this.RestService.get(`https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/comentarios/${id}`)
      .subscribe(response => {
        this.listComentarios = JSON.parse(JSON.stringify(response)).data;
        inputPost.value = "";
      })
  }

  public updateComentarios(id:string) {
    this.RestService.put(`https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/updateComentarios`, {
      id: id,
      comentario: this.form.value.textUpdate,
      fecha_creacion: "2021-06-19T19:43:32.713Z",
      preguntaId: this.id,
      usuarioId: this.userId
    })
      .subscribe(response => {
        console.log(response);
        this.accion = false;
        this.readComentarios(this.id);
      })
  }

  public deleteComentario(id:string) {
    this.RestService.delete(`https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/deleteComentarios/${id}`)
      .subscribe(response => {
        console.log(response);
        this.readComentarios(this.id);
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
