import {Component, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class FlatsService {
  constructor(private http: HttpClient) { }

  rootURL = '/housing';
  getFlat(){
    return this.http.get(this.rootURL + '/flat/all' );
  }

  getReading(id: number){
    const postData = {
      id: id
    };
    return this.http.post(this.rootURL + '/flat/counters', postData);
  }

  getOwners(id: number){
    const postData = {
      id: id
    };
    return this.http.post(this.rootURL + '/flat/owners', postData);
  }

}
