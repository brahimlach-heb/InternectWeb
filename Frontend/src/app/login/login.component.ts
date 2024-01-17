import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string="";
  password: string="";
  user:[username: string, password: string] = ["", ""];
  titre?: string;

  constructor(private http: HttpClient) {}

  onclick(){
    alert(this.titre + " " + this.password);
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    const url = 'http://localhost:8080/api/users/verify';
    const body = {
      username: this.username,
      password: this.password
    };

    this.http.post(url, body, { headers })
      .subscribe(response => {
        // Handle the response as needed
        alert(response);
      }, error => {
        // Handle errors
        console.error(error);
      });
  }

}
