import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent }   from './home/home.component';
import { ConsultaComponent } from './consulta/consulta.component';
import { MkComponent } from './mk/mk.component';
import { VotaComponent } from './vota/vota.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'mk', component: MkComponent },
  { path: 'vota', component: VotaComponent },
  { path: 'consulta', component: ConsultaComponent },
  { path: 'login', component: LoginComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
