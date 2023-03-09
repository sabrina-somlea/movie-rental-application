package ro.ubb.catalog.web.dto;
import lombok.*;
import ro.ubb.catalog.web.converter.BaseConverter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MovieDateDto extends BaseDto {
    private int quarter;
    private int year;
    private String month;
    private int day;

    @Override
    public String toString() {
        return "MovieDateDto{" +
                "quarter=" + quarter +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", day=" + day +
                '}';
    }
}
