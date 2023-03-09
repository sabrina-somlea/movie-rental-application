import {Component, OnInit} from '@angular/core';
import {MovieDateService} from "../shared/date.service";
import {MovieDate} from "../shared/date.model";
import {Location} from '@angular/common';

@Component({
  selector: 'app-date-new',
  templateUrl: './date-new.component.html',
  styleUrls: ['./date-new.component.css']
})
export class MovieDateNewComponent implements OnInit {

  constructor(private movieDateService: MovieDateService,
              private location: Location) {
  }

  ngOnInit(): void {
  }


  onSave(quarter: string, year: string, month: string, day: string) {
    console.log("onSave:", quarter, year, month, day);

    const date: MovieDate = {
      id: 0,
      quarter: +quarter,
      year: +year,
      month,
      day: +day
    };
    this.movieDateService.saveMovieDate(date)
      .subscribe(_ => console.log("ok"));

    this.location.back();
  }

  onUpdate(id: string, quarter: string, year: string, month: string, day: string) {
    console.log("onUpdate:", quarter, year, month, day);

    const date: MovieDate = {id:+id, quarter:+quarter, year: +year, month, day: +day};
    console.log(date.id)
    console.log(date)
    this.movieDateService.updateMovieDate(date)
      .subscribe(_ => console.log("ok"));



    this.location.back();
  }
}
