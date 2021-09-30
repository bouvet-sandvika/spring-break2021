package no.bouvet.deskbooking.repository;

import no.bouvet.deskbooking.models.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}