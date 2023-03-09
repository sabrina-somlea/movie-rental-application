import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../shared/customer.service";
import {Customer} from "../shared/customer.model";
import {Location} from "@angular/common";

@Component({
  selector: 'app-customer-new',
  templateUrl: './customer-new.component.html',
  styleUrls: ['./customer-new.component.css']
})
export class CustomerNewComponent implements OnInit {

  constructor(private customerService: CustomerService, private location: Location) { }

  ngOnInit(): void {
  }


  onSave(name: string, email: string, yearOfBirth: string, gender: string) {
    const customer: Customer = {id: 0,name, email, yearOfBirth: +yearOfBirth, gender};
    console.log("onSave: ", name,email,yearOfBirth,gender);
    this.customerService.saveCustomer(customer)
      .subscribe(_ => {
        console.log("Ok");
        this.location.back();
      });
  }
}
