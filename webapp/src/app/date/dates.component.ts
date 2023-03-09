import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-dates',
  templateUrl: './dates.component.html',
  styleUrls: ['./dates.component.css']
})
export class MovieDatesComponent implements OnInit {
  constructor(private router: Router) {
  }

  ngOnInit(): void {

  }
  addNewMovieDate() {
    console.log("addNewMovieDate called");
    this.router.navigate(['/date-new']);
  }
}
