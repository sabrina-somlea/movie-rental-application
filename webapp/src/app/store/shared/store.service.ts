import {Injectable} from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {Store} from "./store.model";

import {Observable} from "rxjs";
import {map} from "rxjs/operators";


@Injectable()
export class StoreService {
  // private storeURLget = 'http://localhost:8080/api/stores';
  private storeURL = 'http://localhost:8080/api/stores';

  constructor(private httpClient: HttpClient) {
  }

  getStores(): Observable<Store[]> {
    return this.httpClient
      .get<Array<Store>>(this.storeURL);
  }

  getStore(id: number): Observable<Store | undefined> {
    return this.getStores()
      .pipe(
        map(stores => stores.find(store => store.id === id))
      );
  }

  saveStore(store: Store): Observable<Store> {
    return this.httpClient
      .post<Store>(this.storeURL, store);
  }

  deleteStore(id: number): Observable<any> {
    const url = `${this.storeURL}/${id}`;
    return this.httpClient
      .delete(url);
  }

  updateStore(store: Store): Observable<Store> {
    const url = `${this.storeURL}/${store.id}`;
    return this.httpClient
      .put<Store>(url, store);
  }

}
