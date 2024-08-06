import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActionwidgetComponent } from './components/actionwidget/actionwidget.component';
import { MaterialModule } from './material/material/material.module';
import { NavbarComponent } from './components/navbar/navbar/navbar.component';


@NgModule({
  declarations: [
    ActionwidgetComponent,
    NavbarComponent,
    
  ],
  imports: [
    CommonModule,
    MaterialModule,
    
  ],
  exports: [
    ActionwidgetComponent, 
    NavbarComponent,

  ]
})
export class SharedModule { }
