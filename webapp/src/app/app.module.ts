import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {MoviesComponent} from './movies/movies.component';
import {MovieListComponent} from './movies/movie-list/movie-list.component';
import {MovieService} from "./movies/shared/movie.service";
import {MovieNewComponent} from './movies/movie-new/movie-new.component';
import {CustomersComponent} from './customers/customers.component';
import {CustomerListComponent} from './customers/customer-list/customer-list.component';
import {CustomerService} from "./customers/shared/customer.service";
import {CustomerNewComponent} from './customers/customer-new/customer-new.component';
import {CustomerDeleteComponent} from './customers/customer-delete/customer-delete.component';
import {CustomerUpdateComponent} from './customers/customer-update/customer-update.component';
import {DatesListComponent} from "./date/date-list/dates-list.component";
import {MovieDatesComponent} from "./date/dates.component";
import {MovieDateNewComponent} from "./date/date-new/date-new.component";
import {MovieDateService} from "./date/shared/date.service";
import {DateUpdateComponent} from './date/date-update/date-update.component';
import {DateDeleteComponent} from './date/date-delete/date-delete.component';
import {StaffComponent} from "./staff/staff.component";
import {StaffListComponent} from "./staff/staff-list/staff-list.component";
import {StaffNewComponent} from "./staff/staff-new/staff-new.component";
import {StaffDeleteComponent} from "./staff/staff-delete/staff-delete.component";
import {StaffUpdateComponent} from "./staff/staff-update/staff-update.component";
import {StoreService} from "./store/shared/store.service";
import {StaffService} from "./staff/shared/staff.service";
import {StoreComponent} from "./store/store.component";
import {StoreListComponent} from "./store/store-list/store-list.component";
import {StoreNewComponent} from "./store/store-new/store-new.component";

@NgModule({
  declarations: [
    AppComponent,
    MoviesComponent,
    MovieListComponent,
    MovieNewComponent,
    CustomersComponent,
    CustomerListComponent,
    CustomerNewComponent,
    CustomerDeleteComponent,
    CustomerUpdateComponent,
    MovieDatesComponent,
    DatesListComponent,
    MovieDateNewComponent,
    DateUpdateComponent,
    DateDeleteComponent,
    StaffComponent,
    StaffListComponent,
    StaffNewComponent,
    StaffDeleteComponent,
    StaffUpdateComponent,
    StoreComponent,
    StoreListComponent,
    StoreNewComponent,




  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [MovieService, CustomerService, MovieDateService, StoreService, StaffService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
