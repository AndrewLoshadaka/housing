import {Component, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class FlatService {
  constructor(private http: HttpClient) { }

  rootURL = '/housing';
  getReading(id: String){
    const postData = {
      id: id
    };
    return this.http.post(this.rootURL + '/counters', postData).subscribe(
      (response) => {
        console.log('Ok!' + JSON.stringify(response));
      },
      (error) => {
        console.log('error! ' + JSON.stringify(error));
      }
    )
  }

  getOwners(id: String){
    const postData = {
      id: id
    };
    return this.http.post(this.rootURL + '/owners', postData).subscribe(
      (response) => {
        console.log('Ok!' + JSON.stringify(response));
      },
      (error) => {
        console.log('error! ' + JSON.stringify(error));
      }
    )
  }
}



