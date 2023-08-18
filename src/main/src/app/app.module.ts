import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StartComponent } from './start/start.component';
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {MatButtonModule} from "@angular/material/button";
import {RouterModule, Routes} from "@angular/router";
import { OwnersComponent } from './owners/owners.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { FlatsComponent } from './flats/flats.component';
import { OwnerComponent } from './owner/owner.component';
import {MatCardModule} from "@angular/material/card";
import { FlatComponent } from './flat/flat.component';
import {MatExpansionModule} from "@angular/material/expansion";
import {MatTableModule} from "@angular/material/table";

const appRoutes: Routes = [
  {path: 'owners', component: OwnersComponent},
  {path: 'flats', component: FlatsComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    StartComponent,
    OwnersComponent,
    FlatsComponent,
    OwnerComponent,
    FlatComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    AppRoutingModule,
    MatButtonModule,
    MatButtonToggleModule,
    FormsModule,
    HttpClientModule,
    MatCardModule,
    MatExpansionModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
