import { Component, OnInit } from '@angular/core';
import {Location} from "@angular/common";
import {MovieDateService} from "../shared/date.service";
import {MovieDate} from "../shared/date.model";

@Component({
  selector: 'app-date-update',
  templateUrl: './date-update.component.html',
  styleUrls: ['./date-update.component.css']
})
export class DateUpdateComponent implements OnInit {

  constructor(private movieDateService: MovieDateService, private location: Location) { }

  ngOnInit(): void {
  }

  onUpdate(id: string, quarter: string, year: string, month: string, day: string) {
    const date: MovieDate = {id:+id, quarter:+quarter, year: +year, month, day:+day}
    this.movieDateService.updateMovieDate(date)
      .subscribe(_=>{
        console.log("update customer id = ",id);
        this.location.back();
      })
  }

}
