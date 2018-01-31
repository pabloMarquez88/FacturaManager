import { Component, OnInit } from '@angular/core';
import { IntercomunicacionService } from '../services/intercomunicacion.service';

@Component({
  selector: 'app-menu-lateral',
  templateUrl: './menu-lateral.component.html',
  styleUrls: ['./menu-lateral.component.css']
})
export class MenuLateralComponent implements OnInit {

 public mostrarMenu: any = false;

  constructor(private intercomunicacionService: IntercomunicacionService) { }

  ngOnInit() {
    this.intercomunicacionService.getData().subscribe(data => { 
      
      console.warn(data);
      console.warn(this.mostrarMenu);
      this.mostrarMenu = data;
    });
  }

}
