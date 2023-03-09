package ro.ubb.catalog.core.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@Builder
@EqualsAndHashCode(callSuper = true)
public class Movie extends BaseEntity<Long> {
    private String title;
    private int releaseYear;
    private String language;
    private float rating;
    private float rentalPrice;

}
