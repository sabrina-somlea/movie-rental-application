package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Store;

import java.util.List;

public interface StoreService {

    List<Store> getAllStores();

    Store saveStore(Store store);

    Store updateStore(Long id, Store store);

    void deleteStore(Long id);

}
