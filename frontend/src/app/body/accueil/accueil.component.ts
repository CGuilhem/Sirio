import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit {

  produitPopulaires: any[];
  json: any

  produits: any;

  constructor() {
    this.produitPopulaires = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

    this.produits = []

    //fetchData()
    //this.produits = plainToClass(Produit, json)
  }

  async ngOnInit() {
    this.json = await fetch("http://localhost:3000/api/meuble")
      .then(
        function (res) {
          return res.json();
        }
      )
    this.json.forEach((element: any) => this.produits.push(
        new Produit(
          element.categorie,
          element.description,
          element.imagesUrl,
          element.nom,
          element.note,
          element.prix,
          element.stock,
          element.id
        )
      )
    )
    console.log(this.produits)
  }

}


class Produit {
  constructor(categorie: string, description: string, imagesUrl: [string], nom: string, note: number, prix: number, stock: number, id: string) {
    this._categorie = categorie;
    this._description = description;
    this._imagesUrl = imagesUrl;
    this._nom = nom;
    this._note = note;
    this._prix = prix;
    this._stock = stock;
    this._id = id;
  }

  private _categorie: string

  get categorie(): string {
    return this._categorie;
  }

  private _description: string

  get description(): string {
    return this._description;
  }

  private _imagesUrl: [string]

  get imagesUrl(): [string] {
    return this._imagesUrl;
  }

  private _nom: string

  get nom(): string {
    return this._nom;
  }

  private _note: number

  get note(): number {
    return this._note;
  }

  private _prix: number

  get prix(): number {
    return this._prix;
  }

  private _stock: number

  get stock(): number {
    return this._stock;
  }

  private _id: string

  get id(): string {
    return this._id;
  }
}


