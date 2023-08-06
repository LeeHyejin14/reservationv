package zerobase.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.reservation.domain.Partner;

public interface PartnerRepository extends JpaRepository<Partner, Long> {

}
