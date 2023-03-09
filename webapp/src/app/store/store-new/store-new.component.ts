import {Component, OnInit} from '@angular/core';
import {Location} from "@angular/common";
import {StoreService} from "../shared/store.service";
import {Store} from "../shared/store.model";

@Component({
  selector: 'app-movie-new',
  templateUrl: './store-new.component.html',
  styleUrls: ['./store-new.component.css']
})
export class StoreNewComponent implements OnInit {

  constructor(private storeService: StoreService,
              private location: Location) {
  }

  ngOnInit(): void {
  }

  onSave(name: string, address: string, city: string, county: string, postalCode: string) {
    console.log("onSave:", name, address, city, county, postalCode);

    const store: Store = {
      id: 0,
      name,
      address,
      city,
      county,
      postalCode: +postalCode
    };
    this.storeService.saveStore(store)
      .subscribe(_ => console.log("ok"));

    this.location.back();
  }

  onUpdate(id:string, name: string, address: string, city: string, county: string, postalCode: string) {
    console.log("onUpdate:", id, name, address, city, county, postalCode);
    const store: Store = {id:+id, name, address, city, county, postalCode:+postalCode};

  this.storeService.updateStore(store)
    .subscribe(_ => console.log("ok"));

  this.location.back();
  }

}
