
import {Usuario} from "./usuario";
export class Tarea{

  constructor(public id?: number, private descripcion?: string, private iteracion?: number, private asignatario?: Usuario, private fecha?: string, private porcentajeCumplimiento?: number){}

  public contiene(palabra: string): boolean{
    return this.descripcion.includes(palabra) || this.asignatario.nombre.includes(palabra);
  }

  public cumplio(porcentaje: number): boolean{
    return this.porcentajeCumplimiento == porcentaje;
  }

  public cumplioMenosDe(porcentaje: number): boolean{
    return this.porcentajeCumplimiento < porcentaje;
  }

  public sePuedeCumplir(): boolean{
    return this.porcentajeCumplimiento < 100
  }

  public cumplir(){
    this.porcentajeCumplimiento = 100;
  }

  public asignarA(asignatario: Usuario){
    this.asignatario = asignatario
  }

  public estaAsignada(){
    return this.asignatario != null;
  }

  static fromJson(tareaJSON){
    return new Tarea(tareaJSON.id, tareaJSON.descripcion, tareaJSON.iteracion,
      Usuario.fromJson(tareaJSON.asignatario), tareaJSON.fecha, tareaJSON.porcentajeCumplimiento)
  }
}
