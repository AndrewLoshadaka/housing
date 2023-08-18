import {Component, EventEmitter, Input, Output} from '@angular/core';
@Component({
  selector: 'app-owner',
  templateUrl: './owner.component.html',
  styleUrls: ['./owner.component.css']
})
export class OwnerComponent {
  @Input()
  owner: any;

  @Input()
  idOwner: any;

  @Output() ownerSelected = new EventEmitter<number>();

  sendSelectedFlatId(ownerId: number) {
    this.ownerSelected.emit(ownerId);
  }
}
