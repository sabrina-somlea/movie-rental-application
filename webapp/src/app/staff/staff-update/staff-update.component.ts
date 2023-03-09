import { Component, OnInit } from '@angular/core';
import {Staff} from "../shared/staff.model";
import {CustomerService} from "../../customers/shared/customer.service";
import {Location} from "@angular/common";
import {StaffService} from "../shared/staff.service";

@Component({
  selector: 'app-staff-update',
  templateUrl: './staff-update.component.html',
  styleUrls: ['./staff-update.component.css']
})
export class StaffUpdateComponent implements OnInit {

  constructor(private staffService: StaffService, private location: Location) {
  }

  ngOnInit(): void {
  }

  onUpdate(id:string, name: string, yearOfBirth: string, email: string, phoneNumber: string) {
    const staff: Staff = {id:+id, name, yearOfBirth: +yearOfBirth, email, phoneNumber};
    this.staffService.updateStaff(staff)
      .subscribe(_ => {
        console.log("update staff id = ", id);
        this.location.back();
      });

  }
}
