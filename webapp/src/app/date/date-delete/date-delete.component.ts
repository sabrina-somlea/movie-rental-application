import { Component, OnInit } from '@angular/core';
import {MovieDateService} from "../shared/date.service";
import { Location } from '@angular/common';

@Component({
  selector: 'app-date-delete',
  templateUrl: './date-delete.component.html',
  styleUrls: ['./date-delete.component.css']
})
export class DateDeleteComponent implements OnInit {

  constructor(private movieDateService: MovieDateService, private location: Location) { }

  ngOnInit(): void {
  }

  onDelete(id: string) {
    const idToDelete = +id;
    this.movieDateService.deleteMovieDate(idToDelete)
      .subscribe(_=>{
        console.log("deleted id = ", idToDelete);
        this.location.back();
      });
  }

}
