package zerobase.reservation.service;

import org.springframework.stereotype.Service;
import zerobase.reservation.domain.Reservation;
import zerobase.reservation.dto.ReservationRequest;
import zerobase.reservation.repository.ReservationRepository;

import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // 예약
    public Reservation registerReservation(ReservationRequest reservationRequest) {
        Reservation reservation = new Reservation(reservationRequest.getStorename(), reservationRequest.getReservationdate(),
                reservationRequest.getReservationtime());
        return reservationRepository.save(reservation);
    }

    // 예약 조회
    public Reservation checkReservation(Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.orElse(null);
    }

    // 예약 완료
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}