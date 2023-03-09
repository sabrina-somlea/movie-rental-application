import { Component, OnInit } from '@angular/core';
import {Location} from "@angular/common";
import {CustomerService} from "../shared/customer.service";
import {Customer} from "../shared/customer.model";

@Component({
  selector: 'app-customer-update',
  templateUrl: './customer-update.component.html',
  styleUrls: ['./customer-update.component.css']
})
export class CustomerUpdateComponent implements OnInit {

  constructor(private customerService: CustomerService, private location: Location) { }

  ngOnInit(): void {
  }

  onUpdate(id: string, name: string, email: string, year: string, gender: string) {
    const customer: Customer = {id:+id, name,email,yearOfBirth:+year, gender}
    this.customerService.updateCustomer(customer)
      .subscribe(_=>{
        console.log("update customer id = ",id);
        this.location.back();
      })
  }
}
