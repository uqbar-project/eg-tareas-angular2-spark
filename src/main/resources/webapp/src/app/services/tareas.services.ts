
import {Tarea} from "../model/tarea";
import {Http, Response} from "@angular/http";
import {Injectable} from "@angular/core";
import 'rxjs/add/operator/map';

@Injectable()
export class TareasService{

  constructor(private http: Http){}

  public todasLasTareas(){
    return this.http.get("/tareas").map(this.extractData);
  }

  public actualizarTarea(tarea: Tarea){
    this.http.put("/tareas/" + tarea.id, JSON.stringify(tarea)).subscribe();
  }

  private extractData(res: Response){
    let body = res.json();
    let tareas = [];
    body.forEach(tareaJSON => tareas.push(
      Tarea.fromJson(tareaJSON)
    ));
    return tareas;
  }
}
