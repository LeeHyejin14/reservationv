package zerobase.reservation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zerobase.reservation.domain.Partner;
import zerobase.reservation.domain.Store;
import zerobase.reservation.dto.StoreRequest;
import zerobase.reservation.service.PartnerService;
import zerobase.reservation.service.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;
    private final PartnerService partnerService;

    public StoreController(StoreService storeService, PartnerService partnerService) {
        this.storeService = storeService;
        this.partnerService = partnerService;
    }

    // 매장 등록
    @PostMapping("/register")
    public ResponseEntity<String> registerStore(@RequestBody StoreRequest storeRequest) {
        Long partnerId = storeRequest.getPartnerId();

        Partner partner = partnerService.checkPartner(partnerId);
        if (partner == null) {
            return ResponseEntity.notFound().build();
        }

        storeService.registerStore(storeRequest, partner);
        return ResponseEntity.ok("매장 등록 완료");
    }

    // 매장 조회
    @GetMapping("/{name}")
    public ResponseEntity<Store> checkStoreByName(@PathVariable String name) {
        Store store = storeService.checkStore(name);
        if (store != null) {
            store.setPartner(null);
            return ResponseEntity.ok(store);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}