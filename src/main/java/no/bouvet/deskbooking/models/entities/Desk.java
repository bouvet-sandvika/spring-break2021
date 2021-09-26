package no.bouvet.deskbooking.models.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Desk {

    @EmbeddedId
    private DeskId id;
    @OneToMany
    private List<Booking> bookings;

    public Desk() {
    }

    public Desk(DeskId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "Desk[id='%s', office='%s']",
                id.id, id.office.toString());
    }

    public DeskId getId() {
        return id;
    }

    public Office getOffice() {
        return id.office;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    @Embeddable
    public static class DeskId implements Serializable {
        Long id;
        @ManyToOne
        Office office;

        public DeskId() {
        }

        public DeskId(Long id, Office office) {
            this.id = id;
            this.office = office;
        }
    }
}
