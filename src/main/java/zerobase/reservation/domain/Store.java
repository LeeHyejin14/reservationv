package zerobase.reservation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String location;
    private String description;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;

    public Store(String name, String location, String description, Partner partner) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.partner = partner;
    }
}
