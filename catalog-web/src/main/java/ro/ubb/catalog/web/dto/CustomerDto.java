package ro.ubb.catalog.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CustomerDto extends  BaseDto{

    private String name;
    private String email;
    private int yearOfBirth;
    private String gender;

}
