package zerobase.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.reservation.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
