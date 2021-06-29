import { Component, OnInit } from '@angular/core';
import { RestService } from "../rest.service";
import { FormBuilder, FormGroup } from "@angular/forms";
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  public form!: FormGroup;
  public userEmail:any
  public userPassword:any
  public user:any = {}
  constructor(private RestService:RestService,private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      text: ['']
    })
    this.userEmail = localStorage.getItem("userEmail");
    this.userPassword = localStorage.getItem("userPassword");
    this.getData();
  }

  getData() {
    this.RestService.get(`https://app-pull-the-lever.herokuapp.com/pull/v1/usuarios/${this.userEmail}/${this.userPassword}`)
      .subscribe(response => {
        this.user = JSON.parse(JSON.stringify(response)).data;
        console.log(this.user);
      })
  }

  public updateClave() {
    this.RestService.put(`https://app-pull-the-lever.herokuapp.com/pull/v1/usuarios/${this.userEmail}/${this.form.value.text}
`, {
    })
      .subscribe(response => {
        alert("Contraseña cambiada correctamente");
        console.log(response);
      })
  }

}
