package zerobase.reservation.service;

import org.springframework.stereotype.Service;
import zerobase.reservation.domain.Partner;
import zerobase.reservation.dto.PartnerRequest;
import zerobase.reservation.repository.PartnerRepository;

import java.util.Optional;

@Service
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    //파트너 등록
    public Partner registerPartner(PartnerRequest partnerRequest) {
        Partner partner = new Partner(partnerRequest.getName());
        return partnerRepository.save(partner);
    }

    // 파트너 조회
    public Partner checkPartner(Long id) {
        Optional<Partner> partnerOptional = partnerRepository.findById(id);
        return partnerOptional.orElse(null);
    }
}