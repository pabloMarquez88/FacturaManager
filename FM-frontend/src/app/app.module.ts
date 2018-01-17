import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule }     from './app-routing.module';

import { AppComponent } from './app.component';
import { EventoComponent } from './evento/evento.component';
import { EncabezadoComponent } from './encabezado/encabezado.component';
import { MkComponent } from './mk/mk.component';
import { MenuLateralComponent } from './menu-lateral/menu-lateral.component';
import { HomeComponent } from './home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    EventoComponent,
    EncabezadoComponent,
    MkComponent,
    MenuLateralComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
