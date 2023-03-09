import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "./customer.model";
import {Movie} from "../../movies/shared/movie.model";

@Injectable()
export class CustomerService{

  private customersUrl = "http://localhost:8080/api/customers";

  constructor(private httpClient:HttpClient){}

  getCustomers(): Observable<Customer[]> {
    return this.httpClient
      .get<Array<Customer>>(this.customersUrl);
  }

  updateCustomer(customer: Customer): Observable<Customer> {
    const url = `${this.customersUrl}/${customer.id}`;
    return this.httpClient.put<Customer>(url, customer);
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient
      .post<Customer>(this.customersUrl, customer);
  }

  deleteCustomer(id: number): Observable<any> {
    const url = `${this.customersUrl}/${id}`;
    return this.httpClient
      .delete(url);
  }

}
