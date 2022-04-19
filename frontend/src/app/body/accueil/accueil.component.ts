import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit {

  produitPopulaires: any[];

  constructor() {
    this.produitPopulaires = [0,1,2,3,4,5,6,7,8,9];
  }

  ngOnInit(): void {
  }

}
