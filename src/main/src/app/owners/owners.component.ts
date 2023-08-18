import { Component } from '@angular/core';
import {OwnersService} from "./owners.service";

@Component({
  selector: 'app-owners',
  templateUrl: './owners.component.html',
  styleUrls: ['./owners.component.css']
})
export class OwnersComponent {
  sort: any;
  allOwners: any[] = [];
  allFlats: any[] = [];

  selectedOwnerId: number | null = null;
  displayedColumns: String[] = ['flatNumber', 'area', 'floorSpace', 'roomValue'];
  constructor(private ownerService: OwnersService) {}

  onOwnerSelected(ownerId: number) {
    this.selectedOwnerId = ownerId;
    this.allFlats = [];



    this.ownerService.getFlats(ownerId).subscribe((v : any) => {
      this.allFlats = v;
    });
  }

  getOwners(){
    this.allOwners = [];
    this.ownerService.getOwners().subscribe((v: any) => {
      this.allOwners = v;
    })
  }
}
