import {Component, OnInit} from '@angular/core';
import {MovieDateService} from '../shared/date.service';
import {MovieDate} from '../shared/date.model';
@Component({
  selector: 'app-dates-list',
  templateUrl: './dates-list.component.html',
  styleUrls: ['./dates-list.component.css']
})

export class DatesListComponent implements OnInit {
  dates: MovieDate[] = [];

  constructor(private movieDateService: MovieDateService) {
  }

  ngOnInit(): void {
    this.movieDateService.getMovieDate()
      .subscribe(movieDate => this.dates = movieDate)
  }

  onDelete(date: MovieDate) {
    this.movieDateService.deleteMovieDate(date.id)
      .subscribe(_ => {
        console.log("delete-ok");
      })

    this.dates = this.dates.filter(d => d.id !== date.id);
  }
}
