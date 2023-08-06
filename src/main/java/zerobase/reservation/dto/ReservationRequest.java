package zerobase.reservation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class ReservationRequest {
    private String storename;
    private LocalDate reservationdate;
    private LocalTime reservationtime;
}