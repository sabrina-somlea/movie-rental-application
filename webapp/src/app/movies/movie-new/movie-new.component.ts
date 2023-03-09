import {Component, OnInit} from '@angular/core';
import {MovieService} from "../shared/movie.service";
import {Movie} from "../shared/movie.model";
import {Location} from "@angular/common";

@Component({
  selector: 'app-movie-new',
  templateUrl: './movie-new.component.html',
  styleUrls: ['./movie-new.component.css']
})
export class MovieNewComponent implements OnInit {

  constructor(private movieService: MovieService,
              private location: Location) {
  }

  ngOnInit(): void {
  }


  onSave(title: string, releaseYear: string, language: string, rating: string, rentalPrice: string) {
    console.log("onSave:", title, releaseYear, language, rating, rentalPrice);

    const movie: Movie = {
      id: 0,
      title,
      releaseYear: +releaseYear,
      language,
      rating: +rating,
      rentalPrice: +rentalPrice
    };
    this.movieService.saveMovie(movie)
      .subscribe(_ => console.log("ok"));

    // this.movieService.saveMovie(movie)
    //   .subscribe(movie => console.log("ok-saved ", movie));
    //
    // this.movieService.saveMovie(movie)
    //   .subscribe((movie: Movie) => console.log("ok-saved ",movie));
    //
    // this.movieService.saveMovie(movie)
    //   .subscribe(_ => {
    //     console.log("ok");
    //     // this.location.back();
    //   }, err => console.log(err));
    //
    // this.movieService.saveMovie(movie)
    //   .subscribe({
    //     next: (movie: Movie) => {
    //     },
    //     error: (err: any) => {
    //     }
    //   });

    this.location.back();
  }

    onUpdate(id: string, title: string, releaseYear: string, language: string, rating: string, rentalPrice: string) {
      console.log("onUpdate:", title, releaseYear, language, rating, rentalPrice);

      const movie: Movie = {id:+id, title, releaseYear: +releaseYear, language, rating: +rating, rentalPrice: +rentalPrice};
      console.log(movie.id)
      console.log(movie)
      this.movieService.updateMovie(movie)
        .subscribe(_ => console.log("ok"));



      this.location.back();
    }
}
