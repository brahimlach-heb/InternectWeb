import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AcceuilComponent} from "./acceuil/acceuil.component";
import { LoginComponent } from './login/login.component';
import { AcctualiteComponent } from './acctualite/acctualite.component';
import { ProfilComponent } from './profil/profil.component';
import { ViewprofilComponent } from './viewprofil/viewprofil.component';
import { InternshipsComponent } from './internships/internships.component';

const routes: Routes = [
  { path: "", redirectTo:"login-page", pathMatch:"full"},
  { path: "acceuil-page", component: AcceuilComponent},
  { path: "login-page", component: LoginComponent},
  { path: "acctualite-page", component: AcctualiteComponent},
  { path: "profil-page", component: ProfilComponent},
  { path: "viewprofil-page", component: ViewprofilComponent},
  { path: "internships-page", component: InternshipsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
