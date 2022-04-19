import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AccueilComponent} from "./body/accueil/accueil.component";
import {ArticleComponent} from "./body/article/article.component";
import {ConnexionComponent} from "./body/connexion/connexion.component";
import {PanierComponent} from "./body/panier/panier.component";
import {ContactComponent} from "./body/contact/contact.component";
import {LegalMentionsComponent} from "./body/legal-mentions/legal-mentions.component";

const routes: Routes = [
  {
    path: '',
    component: AccueilComponent
  },
  {
    path: 'article',
    component: ArticleComponent
  },
  {
    path: 'connexion',
    component: ConnexionComponent
  },
  {
    path: 'panier',
    component: PanierComponent
  },
  {
    path: 'contact',
    component: ContactComponent
  },
  {
    path: 'mentionsLegals',
    component: LegalMentionsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
