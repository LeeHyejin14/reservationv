package zerobase.reservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import zerobase.reservation.domain.Partner;
import zerobase.reservation.dto.PartnerRequest;
import zerobase.reservation.service.PartnerService;

@RestController
@RequestMapping("/partner")
public class PartnerController {
    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    // 파트너 등록
    @PostMapping("/register")
    public ResponseEntity<String> registerPartner(@Validated @RequestBody PartnerRequest partnerRequest) {
        Partner partner = partnerService.registerPartner(partnerRequest);
        if (partner != null) {
            return ResponseEntity.ok("파트너 등록 완료");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("파트너 등록 실패");
        }
    }

    // 파트너 조회
    @GetMapping("/{id}")
    public ResponseEntity<Partner> checkPartner(@PathVariable Long id) {
        Partner partner = partnerService.checkPartner(id);
        if (partner != null) {
            return ResponseEntity.ok(partner);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
