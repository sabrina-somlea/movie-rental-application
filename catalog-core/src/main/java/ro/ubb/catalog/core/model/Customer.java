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
public class Customer extends BaseEntity<Long>{
    private String name;
    private String email;
    private int yearOfBirth;
    private String gender;
}
