import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {Location} from "@angular/common";
import {StaffService} from "./shared/staff.service";

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  addNewStaff(){
    this.router.navigate(['staff-new']);
  }

  updateStaff(){
    this.router.navigate(['staff-update']);
  }
  deleteStaff(){
    this.router.navigate(['staff-delete']);
  }
}
