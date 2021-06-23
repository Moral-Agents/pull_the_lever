import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { GameComponent } from './game/game.component';
import { HttpClientModule } from "@angular/common/http";
import { ReactiveFormsModule } from "@angular/forms";
import { HeaderGuestComponent } from './header-guest/header-guest.component';
import { FooterComponent } from './footer/footer.component';
import { PreguntaDetailComponent } from './pregunta-detail/pregunta-detail.component';
import { LoginComponent } from './login/login.component';
import { HeaderUserComponent } from './header-user/header-user.component';
import { PlansComponent } from './plans/plans.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    HomeComponent,
    GameComponent,
    HeaderGuestComponent,
    FooterComponent,
    PreguntaDetailComponent,
    LoginComponent,
    HeaderUserComponent,
    PlansComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
