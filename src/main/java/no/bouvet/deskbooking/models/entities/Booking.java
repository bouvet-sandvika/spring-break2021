package no.bouvet.deskbooking.models.entities;

import java.time.LocalDateTime;

public class Booking {

    private Long id;
    private Employee booker;
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
