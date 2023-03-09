package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Store;
import ro.ubb.catalog.core.repository.StoreRepository;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {

    private static final Logger log = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Autowired
    private StoreRepository storeRepository;


    @Override
    public List<Store> getAllStores() {
        List<Store> storeList = storeRepository.findAll();
        return storeList;
    }

    @Override
    public Store saveStore(Store store) {
        log.trace("saveStore - method entered: store={} ", store);
        Store saveStore = storeRepository.save(store);
        log.trace("saveStore - method finished: result={}", saveStore);
        return saveStore;
    }

    @Transactional
    @Override
    public Store updateStore(Long id, Store store) {
        Store updateStore = storeRepository.findById(id).orElseThrow();

        updateStore.setName(store.getName());
        updateStore.setAddress(store.getAddress());
        updateStore.setCity(store.getCity());
        updateStore.setCounty(store.getCounty());
        updateStore.setPostalCode(store.getPostalCode());

        return updateStore;
    }

    @Override
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}
