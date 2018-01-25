import { Persona } from "./persona";
import { Puntuacion } from "./puntuacion";

export class Evento {
    id : number;
    fechaEvento : Date;
    persona1:Persona;
    persona2:Persona;
    puntuaciones:Puntuacion[];
}