package zerobase.reservation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.reservation.domain.Store;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, String> {
    boolean existsByName(String storename);

    Optional<Store> findById(String name);
}