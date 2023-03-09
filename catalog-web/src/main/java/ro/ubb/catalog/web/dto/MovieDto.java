package ro.ubb.catalog.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class MovieDto extends BaseDto{
    private String title;
    private int releaseYear;
    private String language;
    private float rating;
    private float rentalPrice;

}
