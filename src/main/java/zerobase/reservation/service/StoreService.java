package zerobase.reservation.service;

import org.springframework.stereotype.Service;
import zerobase.reservation.domain.Partner;
import zerobase.reservation.domain.Store;
import zerobase.reservation.dto.StoreRequest;
import zerobase.reservation.repository.StoreRepository;

import java.util.Optional;

@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    // 매장 등록
    public Store registerStore(StoreRequest storeRequest, Partner partner) {
        Store store = new Store(storeRequest.getName(), storeRequest.getLocation(),
                storeRequest.getDescription(), partner);
        return storeRepository.save(store);
    }

    // 매장 조회
    public Store checkStore(String name) {
        Optional<Store> storeOptional = storeRepository.findById(name);
        return storeOptional.orElse(null);
    }

    // 등록된 매장인지 확인
    public boolean storeRegistered(String storeName) {
        return storeRepository.existsByName(storeName);
    }
}