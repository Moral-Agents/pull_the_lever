import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GameComponent } from './game/game.component';
import { HomeComponent } from './home/home.component';
import { PreguntaDetailComponent } from './pregunta-detail/pregunta-detail.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from "./login/login.component";
import { PlansComponent } from './plans/plans.component';
const routes: Routes = [
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'register',
    component:RegisterComponent
  },
  {
    path:'game',
    component:GameComponent
  },
  {
    path:'pregunta/:id',
    component:PreguntaDetailComponent
  },
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:'plans',
    component:PlansComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
