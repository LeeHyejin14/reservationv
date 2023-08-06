package zerobase.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.reservation.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}