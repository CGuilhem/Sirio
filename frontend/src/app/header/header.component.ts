import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  @Input() nbProduitPanier: number;

  constructor() {
    this.nbProduitPanier = 0;
  }

  ngOnInit(): void {
  }

}
