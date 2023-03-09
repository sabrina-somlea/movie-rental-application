import { Component, OnInit } from '@angular/core';
import {StaffService} from "../shared/staff.service";
import {Staff} from "../shared/staff.model";

@Component({
  selector: 'app-staff-list',
  templateUrl: './staff-list.component.html',
  styleUrls: ['./staff-list.component.css']
})
export class StaffListComponent implements OnInit {
  staff: Staff[] = [];
  constructor(private staffService: StaffService) { }

  ngOnInit(): void {
    this.staffService.getStaff()
      .subscribe(staff => this.staff = staff);
  }

}
