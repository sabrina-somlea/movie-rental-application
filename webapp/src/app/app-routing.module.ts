import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MoviesComponent} from "./movies/movies.component";
import {MovieNewComponent} from "./movies/movie-new/movie-new.component";
import {CustomersComponent} from "./customers/customers.component";
import {CustomerNewComponent} from "./customers/customer-new/customer-new.component";
import {CustomerDeleteComponent} from "./customers/customer-delete/customer-delete.component";
import {CustomerUpdateComponent} from "./customers/customer-update/customer-update.component";
import {StaffComponent} from "./staff/staff.component";
import {StaffNewComponent} from "./staff/staff-new/staff-new.component";
import {StaffUpdateComponent} from "./staff/staff-update/staff-update.component";
import {StaffDeleteComponent} from "./staff/staff-delete/staff-delete.component";
import {MovieDatesComponent} from "./date/dates.component";
import {MovieDateNewComponent} from "./date/date-new/date-new.component";
import {DateUpdateComponent} from "./date/date-update/date-update.component";
import {DateDeleteComponent} from "./date/date-delete/date-delete.component";
import {StoreComponent} from "./store/store.component";
import {StoreNewComponent} from "./store/store-new/store-new.component";


const routes: Routes = [
  // { path: '', redirectTo: '/home', pathMatch: 'full' },

  {path: 'movies', component: MoviesComponent},
  {path: 'movie-new', component: MovieNewComponent},
  {path: 'customers', component: CustomersComponent},
  {path: 'customer-new', component: CustomerNewComponent},
  {path: 'customer-delete', component: CustomerDeleteComponent},
  {path: 'customer-update', component: CustomerUpdateComponent},
  {path: 'staff', component: StaffComponent},
  {path: 'staff-new', component: StaffNewComponent},
  {path: 'staff-update', component: StaffUpdateComponent},
  {path: 'staff-delete', component: StaffDeleteComponent},
  {path: 'dates', component: MovieDatesComponent},
  {path:'date-new', component: MovieDateNewComponent},
  {path:'date-update', component: DateUpdateComponent},
  {path:'date-delete', component: DateDeleteComponent},
  {path: 'store', component: StoreComponent},
  {path: 'store-new', component: StoreNewComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
