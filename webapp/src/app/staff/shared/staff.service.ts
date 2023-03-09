import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Staff} from "./staff.model";

@Injectable()
export class StaffService{

  private staffUrl = "http://localhost:8080/api/staff";

  constructor(private httpClient:HttpClient){}

  getStaff(): Observable<Staff[]> {
    return this.httpClient
      .get<Array<Staff>>(this.staffUrl);
  }

  saveStaff(staff: Staff): Observable<Staff> {
    return this.httpClient
      .post<Staff>(this.staffUrl, staff);
  }
  updateStaff(staff: Staff): Observable<Staff> {
    const url = `${this.staffUrl}/${staff.id}`;
    return this.httpClient.put<Staff>(url, staff);
  }

  deleteStaff(id: number): Observable<any> {
    const url = `${this.staffUrl}/${id}`;
    return this.httpClient
      .delete(url);
  }

}
