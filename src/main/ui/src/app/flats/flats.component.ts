import { Component } from '@angular/core';
import {OwnersService} from "../owners/owners.service";
import {FlatsService} from "./flats.service";
import {FlatComponent} from "../flat/flat.component";

@Component({
  selector: 'app-flats',
  templateUrl: './flats.component.html',
  styleUrls: ['./flats.component.css']
})
export class FlatsComponent {
  constructor(private flatsService: FlatsService) {}
  allFlats: any[] = [];
  allOwners: any[] = [];
  readings: any[] = [];
  displayedColumns: string[] = ['name', 'passport'];
  displayedColumnsReadings: string[] = ['date', 'value'];

  selectedFlatId: number | null = null;

  onFlatSelected(flatId: number) {
    this.selectedFlatId = flatId;
    this.allOwners = [];
    this.readings = [];

    this.flatsService.getOwners(flatId).subscribe((v: any) => {
      this.allOwners = v;

      }
    )

    this.flatsService.getReading(flatId).subscribe((v : any) => {
      this.readings = v;
      console.log(this.readings[0].readings.length);
    });
  }


  getFlats(){
    this.allFlats = [];
    this.flatsService.getFlat().subscribe((v: any) => {
      this.allFlats = v;
    })
  }

  protected readonly Boolean = Boolean;
}
