import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.scss']
})
export class ProduitComponent implements OnInit {

  @Input() produitCategorie: string;
  @Input() produitDescription: string;
  @Input() produitImagesUrl: [string];
  @Input() produitNom: string;
  @Input() produitNote: number;
  @Input() produitPrix: number;
  @Input() produitStock: number;
  @Input() produitId: string;


  constructor() {
    this.produitCategorie = "";
    this.produitDescription = "";
    this.produitImagesUrl = [""];
    this.produitNom = "";
    this.produitNote = 0;
    this.produitPrix = 0;
    this.produitStock = 0;
    this.produitId = "";
  }

  ngOnInit(): void {
  }

}
