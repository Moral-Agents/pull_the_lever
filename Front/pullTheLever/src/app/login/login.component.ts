import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from "@angular/forms";
import { RestService } from "../rest.service";
import { Router } from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public form!: FormGroup;

  constructor(private formBuilder: FormBuilder, private RestService: RestService, private router: Router) { }

  ngOnInit(): void {
    this.form =this.formBuilder.group( {
      correo:[''],
      clave:['']
      }
    )
  }

  public getUsuario() {
    this.RestService.get(`https://app-pull-the-lever.herokuapp.com/pull/v1/usuarios/${this.form.value.correo}/${this.form.value.clave}`)
      .subscribe(
        data => {
          let user = JSON.parse(JSON.stringify(data)).data
          localStorage.setItem("accessToken", user.id)
          localStorage.setItem("userName",user.nombre)
          localStorage.setItem("userEmail",user.correo)
          localStorage.setItem("userPassword",this.form.value.clave)
          this.router.navigate(["../game"])
      },
      error => {
          console.log(error)
          alert("Usuario o contraseña incorrecta")
        })
  }
}
