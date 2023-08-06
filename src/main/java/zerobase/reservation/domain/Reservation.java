package zerobase.reservation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String store_id;
    private LocalDate reservation_date;
    private LocalTime reservation_time;

    public Reservation(String store_id, LocalDate reservation_date, LocalTime reservation_time) {
        this.store_id = store_id;
        this.reservation_date = reservation_date;
        this.reservation_time = reservation_time;
    }
}
