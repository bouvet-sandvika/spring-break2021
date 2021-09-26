package no.bouvet.deskbooking.repository;

import no.bouvet.deskbooking.models.entities.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {
}
