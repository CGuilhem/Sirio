import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { BodyComponent } from './body/body.component';
import { AccueilComponent } from './body/accueil/accueil.component';
import { PanierComponent } from './body/panier/panier.component';
import { ArticleComponent } from './body/article/article.component';
import { ConnexionComponent } from './body/connexion/connexion.component';
import { MatBadgeModule } from '@angular/material/badge';
import { ContactComponent } from './body/contact/contact.component';
import { ProduitComponent } from './body/accueil/produit/produit.component';
import { LegalMentionsComponent } from './body/legal-mentions/legal-mentions.component';
import { InscriptionComponent } from './body/inscription/inscription.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BodyComponent,
    AccueilComponent,
    PanierComponent,
    ArticleComponent,
    ConnexionComponent,
    ContactComponent,
    ProduitComponent,
    LegalMentionsComponent,
    InscriptionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatBadgeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
