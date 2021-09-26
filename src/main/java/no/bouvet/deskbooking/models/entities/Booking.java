package no.bouvet.deskbooking.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Employee booker;
    private LocalDateTime start;
    private LocalDateTime end;

    public Booking() {
    }
}
