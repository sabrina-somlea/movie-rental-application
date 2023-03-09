package ro.ubb.catalog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Store;
import ro.ubb.catalog.core.service.StoreService;
import ro.ubb.catalog.web.converter.StoreConverter;
import ro.ubb.catalog.web.dto.StoreDto;
import ro.ubb.catalog.web.dto.StoreDtos;

import java.util.List;
import java.util.Set;


@RestController
public class StoreController {
    @Autowired
    private StoreService storeService;

    @Autowired
    private StoreConverter storeConverter;

    @RequestMapping(value = "/stores")
    Set<StoreDto> getAllStores() {
        List<Store> allStores = storeService.getAllStores();
        Set<StoreDto> storeDto = storeConverter.convertModelsToDtos(allStores);
        StoreDtos dtos = new StoreDtos(storeDto);
        return storeDto;
    }

    @RequestMapping(value = "/stores", method = RequestMethod.POST)
    StoreDto saveStore(@RequestBody StoreDto storeDto) {
        Store store = storeConverter.convertDtoToModel(storeDto);
        Store savedStore = storeService.saveStore(store);
        return storeConverter.convertModelToDto(savedStore);
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.PUT)
    StoreDto updateStore(@PathVariable Long id, @RequestBody StoreDto storeDto) {
        return storeConverter.convertModelToDto(
                storeService.updateStore(id,
                        storeConverter.convertDtoToModel(storeDto))
        );
    }

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteStoreById(@PathVariable Long id) {
        storeService.deleteStore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
