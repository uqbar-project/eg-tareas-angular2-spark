import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BootstrapModalModule } from 'ng2-bootstrap-modal';

import { AppComponent } from './app.component';
import {TareasPipe} from "./pipes/tareas.pipe";
import {ComboUsuariosComponent} from "./combo.usuarios.component";

@NgModule({
  declarations: [
    AppComponent, ComboUsuariosComponent, TareasPipe
  ],
  imports: [
    BootstrapModalModule.forRoot({container:document.body}),
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  entryComponents: [
    ComboUsuariosComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
