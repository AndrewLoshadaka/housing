import {Component, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class OwnersService {
  constructor(private http: HttpClient) { }


  rootURL = '/housing';
  getOwners(){
    return this.http.get(this.rootURL + '/owners/all' );
  }

  getFlats(id: any){
    const postData = {
      id: id
    };
    return this.http.post(this.rootURL + '/owners/flats', postData)
  }
}
