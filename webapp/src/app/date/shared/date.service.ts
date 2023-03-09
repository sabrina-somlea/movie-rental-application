import {Injectable} from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {MovieDate} from "./date.model";

import {Observable} from "rxjs";


@Injectable()
export class MovieDateService {
  private movieDateURLget = 'http://localhost:8080/api/moviedate';
  private movieDateURL = 'http://localhost:8080/api/moviedate';

  constructor(private httpClient: HttpClient) {
  }

  getMovieDate(): Observable<MovieDate[]> {
    return this.httpClient
      .get<Array<MovieDate>>(this.movieDateURLget);
  }

  // getMovieDate(id: number): Observable<MovieDate | undefined> {
  //   return this.getMovieDates()
  //     .pipe(
  //       map(movieDates => movieDates.find(movieDate => movieDate.id === id))
  //     );
  // }

  saveMovieDate(movieDate: MovieDate): Observable<MovieDate> {
    return this.httpClient
      .post<MovieDate>(this.movieDateURL, movieDate);
  }

  deleteMovieDate(id: number): Observable<any> {
    const url = `${this.movieDateURL}/${id}`;
    return this.httpClient
      .delete(url);
  }

  updateMovieDate(movieDate: MovieDate): Observable<MovieDate> {
    const url = `${this.movieDateURL}/${movieDate.id}`;
    return this.httpClient
      .put<MovieDate>(url, movieDate);
  }

}
