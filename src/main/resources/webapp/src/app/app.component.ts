import { Component } from '@angular/core';
import {TareasService} from "./services/tareas.services";
import {Tarea} from "./model/tarea";
import {Usuario} from "./model/usuario";
import { DialogService } from "ng2-bootstrap-modal";
import {ComboUsuariosComponent} from "./combo.usuarios.component";

@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
  providers: [TareasService]
})
export class AppComponent {

  private tareaBuscada: string = '';
  private tareas = [];
  private errors = [];

  constructor(private _tareasService: TareasService, private _dialogService: DialogService){}

  ngOnInit(){
    this._tareasService.todasLasTareas().subscribe(data => this.tareas = data, error => this.errors.push(error));
  }

  public cumplir(tarea: Tarea){
    tarea.cumplir();
    this._tareasService.actualizarTarea(tarea);
  }

  public desasignar(tarea: Tarea){
    tarea.asignarA(new Usuario(""));
    this._tareasService.actualizarTarea(tarea)
  }

  mostrarModal(tarea: Tarea) {
    this._dialogService.addDialog(ComboUsuariosComponent, {tarea: tarea});
  }
}
