package zerobase.reservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zerobase.reservation.domain.Reservation;
import zerobase.reservation.domain.User;
import zerobase.reservation.dto.ReservationRequest;
import zerobase.reservation.service.ReservationService;
import zerobase.reservation.service.StoreService;
import zerobase.reservation.service.UserService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    private final StoreService storeService;
    private final UserService userService;

    public ReservationController(ReservationService reservationService, StoreService storeService, UserService userService) {
        this.reservationService = reservationService;
        this.storeService = storeService;
        this.userService = userService;
    }

    // 예약
    @PostMapping("/register")
    public ResponseEntity<?> registerReservation(@RequestParam("userid") String userid,
                                                 @RequestBody ReservationRequest reservationRequest) {
        User user = userService.checkUser(userid);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        String storeName = reservationRequest.getStorename();
        if (!storeService.storeRegistered(storeName)) {
            return ResponseEntity.badRequest().body("등록된 매장이 아닙니다.");
        }

        reservationService.registerReservation(reservationRequest);
        return ResponseEntity.ok("예약 완료");
    }


    // 방문 확인
    @PostMapping("/check")
    public ResponseEntity<?> checkReservation(@RequestParam("id") Long id) {
        Reservation reservation = reservationService.checkReservation(id);

        LocalDateTime reservationDateTime = LocalDateTime.of(reservation.getReservation_date(),
                reservation.getReservation_time());
        LocalDateTime currentDateTime = LocalDateTime.now();

        if (reservation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("예약 정보가 없습니다.");
        } else if (currentDateTime.isBefore(reservationDateTime.minusMinutes(10))) {
            return ResponseEntity.badRequest().body("예약 10분 전부터 방문 확인이 가능합니다.");
        }

        reservationService.saveReservation(reservation);

        return ResponseEntity.ok("방문 확인이 완료되었습니다.");
    }
}
