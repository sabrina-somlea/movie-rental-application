package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;

import ro.ubb.catalog.core.model.Staff;
import ro.ubb.catalog.web.dto.StaffDto;

@Component
public class StaffConverter extends BaseConverter<Staff, StaffDto>{
    @Override
    public Staff convertDtoToModel(StaffDto dto) {
        Staff staff = Staff.builder()
                .name(dto.getName())
                .yearOfBirth(dto.getYearOfBirth())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .build();
        staff.setId(dto.getId());
        return staff;
    }

    @Override
    public StaffDto convertModelToDto(Staff staff) {
        StaffDto dto = StaffDto.builder()
                .name(staff.getName())
                .yearOfBirth(staff.getYearOfBirth())
                .email(staff.getEmail())
                .phoneNumber(staff.getPhoneNumber())
                .build();

        dto.setId(staff.getId());
        return dto;
    }
}
