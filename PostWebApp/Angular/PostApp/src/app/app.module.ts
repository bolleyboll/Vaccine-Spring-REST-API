import { BrowserModule } from '@angular/platform-browser';
import { Component, NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { AddComponent } from './add/add.component';
import { UpdateComponent } from './update/update.component';
import { ViewComponent } from './view/view.component';

export const route: Routes = [
  {
    path: 'Update',
    component: UpdateComponent
  }
]

@NgModule({
  declarations: [AppComponent, AddComponent, UpdateComponent, ViewComponent],
  imports: [BrowserModule, HttpClientModule, RouterModule.forRoot(route)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
