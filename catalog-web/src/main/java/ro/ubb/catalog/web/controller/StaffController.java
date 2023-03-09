package ro.ubb.catalog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Staff;
import ro.ubb.catalog.core.service.StaffService;
import ro.ubb.catalog.web.converter.StaffConverter;
import ro.ubb.catalog.web.dto.StaffDto;
import ro.ubb.catalog.web.dto.StaffDtos;


import java.util.List;
import java.util.Set;

@RestController
public class StaffController {

        @Autowired
        private StaffService staffService;

        @Autowired
        private StaffConverter staffConverter;

        @RequestMapping(value = "/staff")
        Set<StaffDto> getAllStaff() {
            List<Staff> allStaff = staffService.getAllStaff();
            Set<StaffDto> staffDtos = staffConverter.convertModelsToDtos(allStaff);
            StaffDtos dtos = new StaffDtos(staffDtos);
            return staffDtos;
        }

        @RequestMapping(value = "/staff", method = RequestMethod.POST)
        StaffDto saveStaff(@RequestBody StaffDto staffDto) {
            Staff staff = staffConverter.convertDtoToModel(staffDto);
            Staff savedStaff = staffService.saveStaff(staff);
            return staffConverter.convertModelToDto(savedStaff);
        }

        @RequestMapping(value = "/staff/{id}", method = RequestMethod.PUT)
        StaffDto updateStaff(@PathVariable Long id, @RequestBody StaffDto staffDto) {
            return staffConverter.convertModelToDto(
                    staffService.updateStaff(id,
                            staffConverter.convertDtoToModel(staffDto))
            );
        }

        @RequestMapping(value = "/staff/{id}", method = RequestMethod.DELETE)
        ResponseEntity<?> deleteStaffById(@PathVariable Long id) {
            staffService.deleteStaff(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

