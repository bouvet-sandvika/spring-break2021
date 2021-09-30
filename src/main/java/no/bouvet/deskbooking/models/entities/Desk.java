package no.bouvet.deskbooking.models.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Desk {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "booker")
    private List<Booking> bookings;

    @ManyToOne
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

    public String getDeskLabel() {
        return deskLabel;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public void setDeskLabel(String deskLabel) {
        this.deskLabel = deskLabel;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "office=" + office +
                ", deskLabel='" + deskLabel + '\'' +
                '}';
    }
}
