// @ts-ignore
import {Component, OnInit} from '@angular/core';
import {StoreService} from "../shared/store.service";
import {Store} from "../shared/store.model";

// @ts-ignore
@Component({
  selector: 'app-store-list',
  templateUrl: './store-list.component.html',
  styleUrls: ['./store-list.component.css']
})
export class StoreListComponent implements OnInit {
  stores: Store[] = [];

  constructor(private storeService: StoreService) {
  }

  ngOnInit(): void {
    this.storeService.getStores()
      .subscribe((store: Store[]) => this.stores = store);


  }

  onDelete(store: Store) {
    this.storeService.deleteStore(store.id)
      .subscribe(_ => {
        console.log("delete-ok");
        //???? delete here???
      });

    this.stores = this.stores.filter(d => d.id !== store.id);//== ===

  }
}
