import { Component, OnInit } from '@angular/core';
import {StaffService} from "../shared/staff.service";
import {Location} from "@angular/common";
import {Staff} from "../shared/staff.model";

@Component({
  selector: 'app-staff-new',
  templateUrl: './staff-new.component.html',
  styleUrls: ['./staff-new.component.css']
})
export class StaffNewComponent implements OnInit {

  constructor(private staffService: StaffService, private location: Location) {
  }

  ngOnInit(): void {
  }

  onSave(name: string, yearOfBirth: string, email: string, phoneNumber: string) {
    const staff: Staff = {id: 0, name, yearOfBirth: +yearOfBirth, email, phoneNumber};
    console.log("onSave: ", name, yearOfBirth, email, phoneNumber);
    this.staffService.saveStaff(staff)
      .subscribe(_ => {
        console.log("Ok");
        this.location.back();
      });


  }
}
