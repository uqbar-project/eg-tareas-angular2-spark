import {Component, Input} from '@angular/core';
import {UsuariosService} from "./services/usuarios.service";
import {Tarea} from "./model/tarea";
import {Usuario} from "./model/usuario";
import {TareasService} from "./services/tareas.services";
import { DialogComponent, DialogService } from "ng2-bootstrap-modal";

export interface AsignarModel {
  tarea: Tarea
}
@Component({
  selector: 'combo-usuarios',
  templateUrl: './combo.usuarios.component.html',
  providers: [UsuariosService, TareasService]
})
export class ComboUsuariosComponent extends DialogComponent<AsignarModel, boolean> implements AsignarModel{

  tarea: Tarea;
  private asignatario: Usuario;
  private usuariosPosibles = [];
  private errors =[];

  constructor(private _usuariosService: UsuariosService, private _tareasService: TareasService, dialogService: DialogService){
    super(dialogService);
  }

  ngOnInit(){
    this._usuariosService.usuariosPosibles().subscribe(data => this.usuariosPosibles = data);
  }

  public asignar(){
    if (this.asignatario == null){
      this.errors.push("Debe seleccionar un usuario");
      return;
    }else
      this.errors = [];

    this.tarea.asignarA(this.asignatario);
    this._tareasService.actualizarTarea(this.tarea);

    this.close();
  }
}
