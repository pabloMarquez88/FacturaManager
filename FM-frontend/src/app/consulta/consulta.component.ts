import { Component, OnInit } from '@angular/core';
import { EventoService } from '../services/evento.service';
import { Evento } from '../entidades/evento';
import { Puntuacion } from '../entidades/puntuacion';
import { Persona } from '../entidades/persona';
import { Router }  from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styleUrls: ['./consulta.component.css']
})
export class ConsultaComponent implements OnInit {

  eventos : Evento[] = [];

  constructor(private eventoService: EventoService, private loginService: LoginService, private router:Router) { }
  

  ngOnInit() {
    if (!this.loginService.usuario.id){
      this.router.navigateByUrl('/login');
    }
    this.cargarEvento();
  }

  cargarEvento (): void {
    this.eventoService.listarEventos()
    .subscribe(evts => this.eventos = evts);
  }

  totalVotos (puntuaciones:Puntuacion[], personaElegida:Persona) : number {
    let cantidadVotos : number = 0;
    for (let puntu of puntuaciones) {
      if (puntu.personaElegida.id==personaElegida.id){
        cantidadVotos++;
      }
    }
    return cantidadVotos;
  }



}
