import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { AcctualiteComponent } from './acctualite/acctualite.component';
import { ProfilComponent } from './profil/profil.component';
import { ViewprofilComponent } from './viewprofil/viewprofil.component';
import { InternshipsComponent } from './internships/internships.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    AcceuilComponent,
    NavbarComponent,
    FooterComponent,
    LoginComponent,
    AcctualiteComponent,
    ProfilComponent,
    ViewprofilComponent,
    InternshipsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
