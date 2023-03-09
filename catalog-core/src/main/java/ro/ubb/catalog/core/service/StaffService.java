package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> getAllStaff();

    Staff saveStaff(Staff staff);
    Staff updateStaff(Long id, Staff staff);
    void deleteStaff(Long id);

}
