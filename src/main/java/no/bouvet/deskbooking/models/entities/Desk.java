package no.bouvet.deskbooking.models.entities;

import java.util.List;

public class Desk {

    private Long id;
    private List<Booking> bookings;
    private Office office;
    private String deskLabel;

    public Desk() {

    }

    public Desk(Office office, String deskLabel) {
        this.office = office;
        this.deskLabel = deskLabel;
    }

    public Long getId() {
        return id;
    }

    public Office getOffice() {
        return office;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "office=" + office +
                ", deskLabel='" + deskLabel + '\'' +
                '}';
    }
}
