import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule }     from './app-routing.module';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { EventoComponent } from './evento/evento.component';
import { EncabezadoComponent } from './encabezado/encabezado.component';
import { MkComponent } from './mk/mk.component';
import { MenuLateralComponent } from './menu-lateral/menu-lateral.component';
import { HomeComponent } from './home/home.component';
import { ConsultaComponent } from './consulta/consulta.component';
import { VotaComponent } from './vota/vota.component';
import { EventoService } from './services/evento.service';
import { LoginService } from './services/login.service';
import { LoginComponent } from './login/login.component';
import { IntercomunicacionService } from './services/intercomunicacion.service';


@NgModule({
  declarations: [
    AppComponent,
    EventoComponent,
    EncabezadoComponent,
    MkComponent,
    MenuLateralComponent,
    HomeComponent,
    ConsultaComponent,
    VotaComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [EventoService, LoginService, IntercomunicacionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
