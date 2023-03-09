package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Staff;
import ro.ubb.catalog.core.repository.StaffRepository;

import java.util.*;


@Service
public class StaffServiceImpl implements StaffService {
    private static final Logger log = LoggerFactory.getLogger(StaffServiceImpl.class);
    @Autowired
    private StaffRepository staffRepository;


    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff saveStaff(Staff staff) {
        log.trace("saveStaff - method entered: staff={} ", staff);

        Staff saveStaff = staffRepository.save(staff);

        log.trace("saveStaff - method finished: result={}", saveStaff);

        return saveStaff;
    }

    @Transactional
    @Override
    public Staff updateStaff(Long id, Staff staff) {
        log.trace("updateStaff - method entered: staff={} ", staff);
        Staff updateStaff = staffRepository.findById(id).orElseThrow();
        updateStaff.setName(staff.getName());
        updateStaff.setYearOfBirth(staff.getYearOfBirth());
        updateStaff.setEmail(staff.getEmail());
        updateStaff.setPhoneNumber(staff.getPhoneNumber());

        log.trace("updateStaff - method finished: result={}", updateStaff);


        return updateStaff;
    }

    @Override
    public void deleteStaff(Long id) {
        log.trace("deleteStaff - method entered: staff={} ", id);

        staffRepository.deleteById(id);
    }

}
