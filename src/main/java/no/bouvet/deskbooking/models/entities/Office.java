package no.bouvet.deskbooking.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Office {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String location;
    @OneToMany
    private List<Desk> desks;

    public Office() {
    }

    public Office(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return String.format(
                "Office[id=%d, name='%s', location='%s']",
                id, name, location);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Desk> getDesks() {
        return desks;
    }
}
