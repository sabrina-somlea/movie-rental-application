package ro.ubb.catalog.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StaffDto extends BaseDto{
    private String name;
    private int yearOfBirth;
    private String email;
    private String phoneNumber;

    @Override
    public String toString() {
        return "StaffDto{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}' + super.toString();
    }
}
