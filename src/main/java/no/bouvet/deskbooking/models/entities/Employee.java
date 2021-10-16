package no.bouvet.deskbooking.models.entities;

import java.util.List;

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Booking> bookings;

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Employee[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
