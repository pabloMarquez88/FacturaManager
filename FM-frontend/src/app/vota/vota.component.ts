import { Component, OnInit } from '@angular/core';
import { EventoService } from '../services/evento.service';
import { Evento } from '../entidades/evento';
import { Persona } from '../entidades/persona';

@Component({
  selector: 'app-vota',
  templateUrl: './vota.component.html',
  styleUrls: ['./vota.component.css']
})
export class VotaComponent implements OnInit {

  eventoActual : Evento;
  candidatos : Persona[] = new Array();

  constructor(private eventoService : EventoService) { }

  ngOnInit() {
    this.cargarEvento();
  }

  cargarEvento():void{
    this.eventoService.getEventoSemana().subscribe(salida =>{
      this.eventoActual = salida;
      this.candidatos.push(this.eventoActual.persona1);
      this.candidatos.push(this.eventoActual.persona2);
    });
    
  }

}
