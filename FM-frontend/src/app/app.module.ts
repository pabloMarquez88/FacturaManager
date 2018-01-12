import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { EventoComponent } from './evento/evento.component';
import { EncabezadoComponent } from './encabezado/encabezado.component';


@NgModule({
  declarations: [
    AppComponent,
    EventoComponent,
    EncabezadoComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
