package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Store extends BaseEntity<Long> implements Serializable {
    private String name;
    private String address;
    private String city;
    private String county;
    private int postalCode;
}
