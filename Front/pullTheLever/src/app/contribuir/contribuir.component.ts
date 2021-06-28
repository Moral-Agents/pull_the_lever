import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { RestService } from '../rest.service';
import { FormBuilder, FormGroup } from "@angular/forms";
@Component({
  selector: 'app-contribuir',
  templateUrl: './contribuir.component.html',
  styleUrls: ['./contribuir.component.css']
})
export class ContribuirComponent implements OnInit {
  public form!: FormGroup;
  public userId:any;
 
  constructor(private router: Router, private formBuilder: FormBuilder,private RestService: RestService) { }

  ngOnInit(): void {
    
    this.form = this.formBuilder.group({
      name: [''],
      description: [''],
      opcion1:[''],
      opcion2:['']
    })
    this.userId = localStorage.getItem("accessToken");
  }

  public createPregunta(){
    this.RestService.post('https://app-pull-the-lever.herokuapp.com/pull/v1/preguntas', {
      autor: "autor",
      descripcion: this.form.value.description,
      nombre: this.form.value.name,
      opcion_1: this.form.value.opcion1,
      opcion_2: this.form.value.opcion2
    })
      .subscribe(respuesta => {
        console.log("Success");
        alert("Dilema creado correctamente")
        this.router.navigate(["../game"])
      })
  }
}
