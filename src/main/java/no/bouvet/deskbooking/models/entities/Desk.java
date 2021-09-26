package no.bouvet.deskbooking.models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Desk {

    @Id
    private Long id;
    @ManyToOne
    private Office office;
    @OneToMany
    private List<Booking> bookings;
}
