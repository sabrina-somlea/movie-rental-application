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
public class MovieDate extends BaseEntity<Long> {
    private int quarter;
    private int year;
    private String month;
    private int day;
}
