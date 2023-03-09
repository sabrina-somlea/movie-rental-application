package ro.ubb.catalog.web.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
@Builder
public class StoreDto extends BaseDto{

    private String name;
    private String address;
    private String city;
    private String county;
    private int postalCode;

    @Override
    public String toString() {
        return "StoreDto{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", city='" + city + '\'' +
                ", county=" + county +
                ", postalCode=" + postalCode +
                "} " + super.toString();
    }

}
