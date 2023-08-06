package zerobase.reservation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StoreRequest {
    private String name;
    private String location;
    private String description;
    private Long partnerId;
}