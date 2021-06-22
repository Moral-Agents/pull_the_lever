import { Component, OnInit } from '@angular/core';
import { RestService } from "../rest.service";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public form!: FormGroup;

  constructor(private formBuilder: FormBuilder, private RestService: RestService, private router: Router) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      nombre:['', [Validators.required, Validators.minLength(8), Validators.maxLength(30)]],
      correo:['', [Validators.required, Validators.email]],
      clave:['', [Validators.required, Validators.minLength(8), Validators.maxLength(30)]],
      edad:[''],
      nacionalidad:[''],
      genero:[''],
      }
    )
  }

  public createUser() {
    this.RestService.post('https://app-pull-the-lever.herokuapp.com/pull-the-lever/v1/usuario', {
      nombre: this.form.value.nombre,
      correo: this.form.value.correo,
      clave: this.form.value.clave,
      edad: this.form.value.edad,
      nacionalidad: this.form.value.nacionalidad,
      genero: this.form.value.genero,
      tipo: "C",
    })
      .subscribe(response => {
        console.log(response);
        this.router.navigate(["../login"])
      })
  }
}
