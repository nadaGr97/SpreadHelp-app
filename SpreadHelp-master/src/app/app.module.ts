import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './home/header/header.component';
import { FooterComponent } from './home/footer/footer.component';
import { ContainerComponent } from './home/container/container.component';
import { ActualiteComponent } from './actualite/actualite.component';
import { AideComponent } from './aide/aide.component';
import { LoginComponent } from './login/login.component';
import { PortailCytoyensComponent } from './portail-cytoyens/portail-cytoyens.component';
import { ContactComponent } from './contact/contact.component';
import { ConsulterDemandeComponent } from './consulter-demande/consulter-demande.component';
import { PublierComponent } from './publier/publier.component';
import { ErreurComponent } from './erreur/erreur.component';
import { AssociationComponent } from './association/association.component';
import { CandidatutreComponent } from './candidatutre/candidatutre.component';
import { ProfileComponent } from './profile/profile.component';
import { MapComponent } from './map/map.component';
import { MonProfileComponent } from './mon-profile/mon-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    ContainerComponent,
    ActualiteComponent,
    AideComponent,
    LoginComponent,
    PortailCytoyensComponent,
    ContactComponent,
    ConsulterDemandeComponent,
    PublierComponent,
    ErreurComponent,
    AssociationComponent,
    CandidatutreComponent,
    ProfileComponent,
    MapComponent,
    MonProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
