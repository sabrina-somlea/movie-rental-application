import {Injectable} from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {Movie} from "./movie.model";

import {Observable} from "rxjs";
import {map} from "rxjs/operators";


@Injectable()
export class MovieService {
  private movieURLget = 'http://localhost:8080/api/moviesSet';
  private movieURL = 'http://localhost:8080/api/movies';

  constructor(private httpClient: HttpClient) {
  }

  getMovies(): Observable<Movie[]> {
    return this.httpClient
      .get<Array<Movie>>(this.movieURLget);
  }

  getMovie(id: number): Observable<Movie | undefined> {
    return this.getMovies()
      .pipe(
        map(movies => movies.find(movie => movie.id === id))
      );
  }

  saveMovie(movie: Movie): Observable<Movie> {
    return this.httpClient
      .post<Movie>(this.movieURL, movie);
  }

  deleteMovie(id: number): Observable<any> {
    const url = `${this.movieURL}/${id}`;
    return this.httpClient
      .delete(url);
  }

  updateMovie(movie: Movie): Observable<Movie> {
    const url = `${this.movieURL}/${movie.id}`;
    return this.httpClient
      .put<Movie>(url, movie);
  }

}
