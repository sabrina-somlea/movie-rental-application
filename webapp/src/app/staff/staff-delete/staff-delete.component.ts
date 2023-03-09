import { Component, OnInit } from '@angular/core';
import {Location} from "@angular/common";
import {ActivatedRoute} from "@angular/router";
import {StaffService} from "../shared/staff.service";

@Component({
  selector: 'app-staff-delete',
  templateUrl: './staff-delete.component.html',
  styleUrls: ['./staff-delete.component.css']
})
export class StaffDeleteComponent implements OnInit {

  constructor(private staffService: StaffService, private location: Location, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }
  onDelete(id: string) {
    const idToDelete = +id;
    this.staffService.deleteStaff(idToDelete)
      .subscribe(_=>{
        console.log("deleted id = ", idToDelete);
        this.location.back();
      });
  }
}
