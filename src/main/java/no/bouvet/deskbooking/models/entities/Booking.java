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
    @ManyToOne
    private Desk desk;
    private LocalDateTime start;
    private LocalDateTime end;

    public Booking() {
    }

    public Booking(Employee booker, Desk desk, LocalDateTime start, LocalDateTime end) {
        this.booker = booker;
        this.desk = desk;
        this.start = start;
        this.end = end;
    }


    @Override
    public String toString() {
        return String.format(
                "Booking[Employee='%s', Desk='%s', start='%s', end='%s']",
                booker.toString(), desk.toString(), start, end);
    }

    public Long getId() {
        return id;
    }

    public Employee getBooker() {
        return booker;
    }

    public Desk getDesk() {
        return desk;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}
