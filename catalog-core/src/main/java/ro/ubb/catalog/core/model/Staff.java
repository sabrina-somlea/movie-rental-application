package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Staff extends BaseEntity<Long>{
    private String name;
    private int yearOfBirth;
    private String email;
    private String phoneNumber;
}
