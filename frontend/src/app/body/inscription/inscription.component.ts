import {Component, OnInit} from '@angular/core';


@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent implements OnInit {

  form: any;

  constructor() {

  }

  ngOnInit(): void {
    this.form = document.querySelector('#connexionForm');
    this.form.addEventListener('submit', this.handleSubmit);
  }

  handleSubmit(event: any) {
    event.preventDefault();

    const data = new FormData(this.form);
    const json = Object.fromEntries((<any>data).entries());

    console.log(json);
    if (json.confPassword == json.password) {
      const xhr = new XMLHttpRequest();
      xhr.open('POST', 'http://192.168.20.145:3000/api/auth/signup');
      xhr.setRequestHeader("Accept", "application/json");
      xhr.setRequestHeader("Content-type", "application/json");

      xhr.send(JSON.stringify(json));
    } else {
      console.log("mot de passe non similaire")
    }
  }


}
