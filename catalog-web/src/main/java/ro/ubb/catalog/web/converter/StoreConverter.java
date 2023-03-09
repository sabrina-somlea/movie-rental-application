package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.Store;
import ro.ubb.catalog.web.dto.StoreDto;


@Component
public class StoreConverter extends BaseConverter<Store, StoreDto> {
    @Override
    public Store convertDtoToModel(StoreDto dto) {
        Store store = Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .city(dto.getCity())
                .county(dto.getCounty())
                .postalCode(dto.getPostalCode())
                .build();
        store.setId(dto.getId());
        return store;
    }

    @Override
    public StoreDto convertModelToDto(Store store) {
        StoreDto dto = StoreDto.builder()
                .name(store.getName())
                .address(store.getAddress())
                .city(store.getCity())
                .county(store.getCounty())
                .postalCode(store.getPostalCode())
                .build();
        dto.setId(store.getId());
        return dto;
    }
}
