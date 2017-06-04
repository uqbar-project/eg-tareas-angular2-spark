import {PipeTransform, Pipe, Injectable} from "@angular/core";
import {Tarea} from "../model/tarea";

@Pipe({
  name: 'filterTareas'
})
export class TareasPipe implements PipeTransform {

  transform(tareas: Tarea[], palabra: string): any {
    return tareas.filter(tarea => tarea.contiene(palabra));
  }


}
