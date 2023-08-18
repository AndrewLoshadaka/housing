import {Component, EventEmitter, Input, Output} from '@angular/core';
import {FlatService} from "./flat.service";

@Component({
  selector: 'app-flat',
  templateUrl: './flat.component.html',
  styleUrls: ['./flat.component.css']
})
export class FlatComponent {

  constructor(flatService: FlatService) {}

  @Input()
  flat: any;
  @Input()
  idFlat: any;

  @Output() flatSelected = new EventEmitter<number>();

  sendSelectedFlatId(flatId: number) {
    this.flatSelected.emit(flatId);
  }


/**
 *надо получить массив с владельцами и массив с показаниями счетчиков
 * */


  protected readonly console = console;
}
