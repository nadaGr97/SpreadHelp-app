import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ContainerComponent} from './home/container/container.component';
import {HomeComponent} from './home/home.component';
import {ActualiteComponent} from './actualite/actualite.component';
import {AideComponent} from './aide/aide.component';
import {PortailCytoyensComponent} from './portail-cytoyens/portail-cytoyens.component';
import {LoginComponent} from './login/login.component';
import {ConsulterDemandeComponent} from './consulter-demande/consulter-demande.component';
import {PublierComponent} from './publier/publier.component';
import {ErreurComponent} from './erreur/erreur.component';
import {ContactComponent} from './contact/contact.component';
import {AssociationComponent} from './association/association.component';
import {CandidatutreComponent} from './candidatutre/candidatutre.component';
import {ProfileComponent} from './profile/profile.component';
import { MapComponent } from './map/map.component';
import {MonProfileComponent} from './mon-profile/mon-profile.component';


const routes: Routes = [
  {path: '', component: HomeComponent, children: [
      {path: '', component: ContainerComponent},
      {path: 'aide' , component : AideComponent},
      {path: 'portailcitoyens', component : PortailCytoyensComponent},
      {path: 'actualite', component: ActualiteComponent},
      {path: 'consulte-demande' , component: ConsulterDemandeComponent},
      {path: 'publier' , component: PublierComponent},
      {path: 'contact' , component: ContactComponent},
      {path: 'association' , component: AssociationComponent},
      {path: 'candidature' , component: CandidatutreComponent},
      {path: 'profile' , component: ProfileComponent},
      {path: 'monprofile' , component: MonProfileComponent}
    ]},
  {path:  'login', component: LoginComponent},
  {path: 'erreur' , component: ErreurComponent},
  {path: 'map' , component: MapComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

