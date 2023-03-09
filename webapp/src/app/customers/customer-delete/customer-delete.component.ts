import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../shared/customer.service";
import {Location} from "@angular/common";
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {

  constructor(private customerService: CustomerService, private location: Location, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  onDelete(id: string) {
    const idToDelete = +id;
    this.customerService.deleteCustomer(idToDelete)
      .subscribe(_=>{
        console.log("deleted id = ", idToDelete);
        this.location.back();
      });
  }
}
